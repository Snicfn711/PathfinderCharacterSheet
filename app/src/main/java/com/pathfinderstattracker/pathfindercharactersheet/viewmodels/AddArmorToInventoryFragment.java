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
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.database.database_entities.ArmorEntity;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
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
    public void onGetAllArmorsAsyncTaskFinished(List<ArmorEntity> result)
    {
        //We have to copy our result to a final object, otherwise we can't properly bind our results to their respective TextViews
        final List<ArmorEntity> listToDisplay = result;
        Spinner armorSpinner = rootView.findViewById(R.id.AddArmorToInventoryDropdown);
        ArrayAdapter<ArmorEntity> armorAdapter = new ArrayAdapter<ArmorEntity>(this.getContext(), R.layout.dropdown_item_view, listToDisplay);
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

                acBonusDisplay.setText(Integer.toString(listToDisplay.get(position).getAcBonus()));
                if(listToDisplay.get(position).getMaximumDexBonus() != null)
                {
                    maxDexterityBonusDisplay.setText(Integer.toString(listToDisplay.get(position).getMaximumDexBonus()));
                }
                else
                {
                    maxDexterityBonusDisplay.setText(getString(R.string.Emdash));
                }
                if(listToDisplay.get(position).getArmorCheckPenalty() != 0)
                {
                    armorCheckPenaltyDisplay.setText(Integer.toString(listToDisplay.get(position).getArmorCheckPenalty()));
                }
                else
                {
                    armorCheckPenaltyDisplay.setText(getString(R.string.Emdash));
                }
                if(listToDisplay.get(position).getArcaneSpellFailureChance() != 0)
                {
                    arcaneSpellFailureDisplay.setText(Integer.toString(listToDisplay.get(position).getArcaneSpellFailureChance()));
                }
                else
                {
                    arcaneSpellFailureDisplay.setText("-");
                }
                weightDisplay.setText(Double.toString(listToDisplay.get(position).getWeight()));
                costDisplay.setText(Double.toString(listToDisplay.get(position).getCost()));
                if(listToDisplay.get(position).getMaxSpeed() != null)
                {
                    maxSpeedDisplay.setText(Integer.toString(listToDisplay.get(position).getMaxSpeed()));
                }
                else
                {
                    maxSpeedDisplay.setText(getString(R.string.Emdash));
                }
                descriptionDisplay.setText(listToDisplay.get(position).getDescription());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                //Do nothing
            }
        });
    }
}
