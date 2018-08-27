package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AddMundaneProtectionToInventorySpinnerAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;

import java.util.ArrayList;
import java.util.List;

public class AddArmorToInventoryFragment extends Fragment implements PathfinderRepository.GetAllMundaneProtectionsAsyncTaskFinishedListener
{
    private View rootView;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public AddArmorToInventoryFragment()
    {
    }

    @SuppressWarnings("unused")
    public static AddArmorToInventoryFragment newInstance(int columnCount)
    {
        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here
        AddArmorToInventoryFragment fragment = new AddArmorToInventoryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.add_armor_to_inventory_tab_view, container, false);
        rootView.setTag("AddArmorRootView");
        Context context = rootView.getContext();
        PathfinderRepository repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestMundaneProtections(this);

        return rootView;
    }


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener)
        {
            mListener = (OnListFragmentInteractionListener) context;
        } else
        {
            throw new RuntimeException(context.toString()
                                               + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(IProtection item);
    }

    @Override
    public void onGetAllMundaneProtectionsAsyncTaskFinished(List<IProtection> result)
    {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Unfortunately the process for getting section headers into our armor select dropdown is convoluted, since the adapter can't modify its data set easily  //
        //This means we end up having to modify it here in the fragment instead and pass the resulting List into the adapter.                                     //
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        final List<Object> mundaneProtectionArrayWithSectionHeaders = new ArrayList<>();

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Since we can't add empty spaces to our data set for the adapter to read as section headers and modify there,  //
        //we're instead forced to put the section header strings directly into the list and handle them in the adapter  //
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mundaneProtectionArrayWithSectionHeaders.add("Select An Item");
        mundaneProtectionArrayWithSectionHeaders.add("Light Armors");

        for (int i = 0; i < result.size() - 1; i++)
        {
            mundaneProtectionArrayWithSectionHeaders.add(result.get(i));

            if(result.get(i).getArmorType() == ArmorTypesEnum.Armor &&
                    result.get(i + 1).getArmorType() == ArmorTypesEnum.Armor)
            {
                IArmor currentArmor = (IArmor)result.get(i);
                IArmor nextArmor = (IArmor)result.get(i + 1);

                if (currentArmor.getWeightCategory() == ArmorWeightCategoryEnum.Light &&
                        nextArmor.getWeightCategory() == ArmorWeightCategoryEnum.Medium)
                {
                    mundaneProtectionArrayWithSectionHeaders.add("Medium Armors");
                }
                if (currentArmor.getWeightCategory() == ArmorWeightCategoryEnum.Medium &&
                        nextArmor.getWeightCategory() == ArmorWeightCategoryEnum.Heavy)
                {
                    mundaneProtectionArrayWithSectionHeaders.add("Heavy Armors");
                }
            }


            if (result.get(i).getArmorType() == ArmorTypesEnum.Armor &&
                    result.get(i + 1).getArmorType() == ArmorTypesEnum.Shield)
            {
                mundaneProtectionArrayWithSectionHeaders.add("Shields");
            }
        }

        Spinner mundaneProtectionsSpinner = rootView.findViewById(R.id.AddArmorToInventoryDropdown);

        AddMundaneProtectionToInventorySpinnerAdapter mundaneProtectionAdapter = new AddMundaneProtectionToInventorySpinnerAdapter(this.getContext(), R.layout.dropdown_item_view, mundaneProtectionArrayWithSectionHeaders);
        mundaneProtectionsSpinner.setAdapter(mundaneProtectionAdapter);
        mundaneProtectionsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                TextView acBonusDisplay = rootView.findViewById(R.id.AddArmorToInventoryACBonusDisplay);
                TextView maxDexterityBonusDisplay = rootView.findViewById(R.id.AddArmorToInventoryMaxDexBonusDisplay);
                TextView armorCheckPenaltyDisplay = rootView.findViewById(R.id.AddArmorToInventoryArmorPenaltyDisplay);
                TextView arcaneSpellFailureDisplay = rootView.findViewById(R.id.AddArmorToInventoryArcaneSpellFailureDisplay);
                TextView weightDisplay = rootView.findViewById(R.id.AddArmorToInventoryWeightDisplay);
                TextView costDisplay = rootView.findViewById(R.id.AddArmorToInventoryCostDisplay);
                TextView maxSpeedDisplay = rootView.findViewById(R.id.AddArmorToInventorySpeedDisplay);
                TextView descriptionDisplay = rootView.findViewById(R.id.AddArmorToInventoryDescriptionDisplay);

                if(mundaneProtectionArrayWithSectionHeaders.get(position) instanceof String)
                {
                    //Our spinner starts with a default string so we don't want to have our screen filled with unrelated information.
                    //This also allows us to more gracefully handle if our section headers are accidentally made selectable/tone is somehow seected
                    acBonusDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    maxDexterityBonusDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    armorCheckPenaltyDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    arcaneSpellFailureDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    weightDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    costDisplay .setText(getContext().getResources().getString(R.string.Emdash));
                    maxSpeedDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    descriptionDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                }
                else if(mundaneProtectionArrayWithSectionHeaders.get(position) instanceof IProtection)
                {
                    IProtection mundaneProtectionToVerify = (IProtection)mundaneProtectionArrayWithSectionHeaders.get(position); 
                    acBonusDisplay.setText(Integer.toString(mundaneProtectionToVerify.getACBonus()));
                    if (mundaneProtectionToVerify.getMaximumDexBonus() != null)
                    {
                        maxDexterityBonusDisplay.setText(Integer.toString(mundaneProtectionToVerify.getMaximumDexBonus()));
                    }
                    else
                    {
                        maxDexterityBonusDisplay.setText(getString(R.string.Emdash));
                    }
                    if (mundaneProtectionToVerify.getArmorCheckPenalty() != 0)
                    {
                        armorCheckPenaltyDisplay.setText(Integer.toString(mundaneProtectionToVerify.getArmorCheckPenalty()));
                    }
                    else
                    {
                        armorCheckPenaltyDisplay.setText(getString(R.string.Emdash));
                    }
                    if (mundaneProtectionToVerify.getArcaneSpellFailureChance() != 0)
                    {
                        arcaneSpellFailureDisplay.setText(Integer.toString(mundaneProtectionToVerify.getArcaneSpellFailureChance()));
                    }
                    else
                    {
                        arcaneSpellFailureDisplay.setText("-");
                    }
                    weightDisplay.setText(Double.toString(mundaneProtectionToVerify.getCurrentWeight()));
                    costDisplay.setText(Double.toString(mundaneProtectionToVerify.getCost()));
                    maxSpeedDisplay.setText(getString(R.string.Emdash));
                    if(mundaneProtectionToVerify instanceof IArmor)
                    {
                        if (((IArmor) mundaneProtectionToVerify).getMaxSpeed() != null)
                        {
                            maxSpeedDisplay.setText(Integer.toString(((IArmor)mundaneProtectionToVerify).getMaxSpeed()));
                        }
                    }
                    descriptionDisplay.setText(mundaneProtectionToVerify.getDescription());
                }
                else
                {
                    throw new RuntimeException("A non-armor item was erroneously added via the add armor to inventory menu");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //Do nothing
            }
        });
    }
}

