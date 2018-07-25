package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.adapters.AddArmorToInventorySpinnerAdapter;
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorTypesEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;

import java.util.ArrayList;
import java.util.List;

public class AddArmorToInventoryFragment extends Fragment implements PathfinderRepository.GetAllArmorsAsyncTaskFinishedListener
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
        if (getArguments() != null)
        {
            //Like above, since we don't have any paramters yet, there's not much to do here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.add_armor_to_inventory_tab_view, container, false);
        rootView.setTag("AddArmorRootView");
        Context context = rootView.getContext();
        PathfinderRepository repository = new PathfinderRepository(this.getActivity().getApplication());
        repository.requestArmors(this);

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
    public void onPause()
    {
        super.onPause();
    }

    @Override
    public void onGetAllArmorsAsyncTaskFinished(List<ArmorEntity> result)
    {
        final List<Object> lightArmorEntityArray = new ArrayList<>();
        final List<Object> mediumArmorEntityArray = new ArrayList<>();
        final List<Object> heavyArmorEntityArray = new ArrayList<>();
        final List<Object> shieldEntityArray = new ArrayList<>();
        final List<Object> armorEntityArrayWithSectionHeaders = new ArrayList<>();

        lightArmorEntityArray.add("Select An Item");
        lightArmorEntityArray.add("Light Armors");
        mediumArmorEntityArray.add("Medium Armors");
        heavyArmorEntityArray.add("Heavy Armors");
        shieldEntityArray.add("Shields");

        for (int i = 0; i < result.size() - 1; i++)
        {
            //Since the default weight category is Light, we also need to make sure that the armor type is armor,
            //otherwise we end up getting shields in our light armor list.
            if (result.get(i).getWeightCategory() == ArmorWeightCategoryEnum.Light &&
                    result.get(i).getArmorType() == ArmorTypesEnum.Armor)
            {
                lightArmorEntityArray.add(result.get(i));
            }
            //There aren't any shields that fall into different armor weight categories, and we shouldn't expect any to exist
            if (result.get(i).getWeightCategory() == ArmorWeightCategoryEnum.Medium)
            {
                mediumArmorEntityArray.add(result.get(i));
            }
            if (result.get(i).getWeightCategory() == ArmorWeightCategoryEnum.Heavy)
            {
                heavyArmorEntityArray.add(result.get(i));
            }
            if (result.get(i).getArmorType() == ArmorTypesEnum.Shield)
            {
                shieldEntityArray.add(result.get(i));
            }
        }

        armorEntityArrayWithSectionHeaders.addAll(lightArmorEntityArray);
        armorEntityArrayWithSectionHeaders.addAll(mediumArmorEntityArray);
        armorEntityArrayWithSectionHeaders.addAll(heavyArmorEntityArray);
        armorEntityArrayWithSectionHeaders.addAll(shieldEntityArray);

        Spinner armorSpinner = rootView.findViewById(R.id.AddArmorToInventoryDropdown);

        AddArmorToInventorySpinnerAdapter armorAdapter = new AddArmorToInventorySpinnerAdapter(this.getContext(), R.layout.dropdown_item_view, armorEntityArrayWithSectionHeaders);
        armorSpinner.setAdapter(armorAdapter);
        armorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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

                if(armorEntityArrayWithSectionHeaders.get(position) instanceof String)
                {
                    acBonusDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    maxDexterityBonusDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    armorCheckPenaltyDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    arcaneSpellFailureDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    weightDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    costDisplay .setText(getContext().getResources().getString(R.string.Emdash));
                    maxSpeedDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                    descriptionDisplay.setText(getContext().getResources().getString(R.string.Emdash));
                }
                else if(armorEntityArrayWithSectionHeaders.get(position) instanceof ArmorEntity)
                {
                    ArmorEntity armorToVerify = (ArmorEntity)armorEntityArrayWithSectionHeaders.get(position); 
                    acBonusDisplay.setText(Integer.toString(armorToVerify.getAcBonus()));
                    if (armorToVerify.getMaximumDexBonus() != null)
                    {
                        maxDexterityBonusDisplay.setText(Integer.toString(armorToVerify.getMaximumDexBonus()));
                    }
                    else
                    {
                        maxDexterityBonusDisplay.setText(getString(R.string.Emdash));
                    }
                    if (armorToVerify.getArmorCheckPenalty() != 0)
                    {
                        armorCheckPenaltyDisplay.setText(Integer.toString(armorToVerify.getArmorCheckPenalty()));
                    }
                    else
                    {
                        armorCheckPenaltyDisplay.setText(getString(R.string.Emdash));
                    }
                    if (armorToVerify.getArcaneSpellFailureChance() != 0)
                    {
                        arcaneSpellFailureDisplay.setText(Integer.toString(armorToVerify.getArcaneSpellFailureChance()));
                    }
                    else
                    {
                        arcaneSpellFailureDisplay.setText("-");
                    }
                    weightDisplay.setText(Double.toString(armorToVerify.getWeight()));
                    costDisplay.setText(Double.toString(armorToVerify.getCost()));
                    if (armorToVerify.getMaxSpeed() != null)
                    {
                        maxSpeedDisplay.setText(Integer.toString(armorToVerify.getMaxSpeed()));
                    }
                    else
                    {
                        maxSpeedDisplay.setText(getString(R.string.Emdash));
                    }
                    descriptionDisplay.setText(armorToVerify.getDescription());
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

