package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.pathfinderstattracker.pathfindercharactersheet.R;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Armor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ArmorWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.Damage;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmor;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IArmorEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IEquipment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IProtection;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IShield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.IWeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Shield;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.ShieldWeightCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.Weapon;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponDamageTypeEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponEnchantment;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponFamilyEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.items.WeaponWeightClassEnum;
import com.pathfinderstattracker.pathfindercharactersheet.views.ProtectionDetailView;
import com.pathfinderstattracker.pathfindercharactersheet.views.WeaponDetailView;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EquipmentReferenceFragment extends Fragment
{

    //region Temp Equipment List
    private WeaponEnchantment flaming = new WeaponEnchantment("Flaming",new Damage(1,6), "Fire", +1, "");
    private ArrayList<IWeaponEnchantment> tempEnchantments = new ArrayList<>();
    private Weapon sword = new Weapon("Longsword",
                                     WeaponFamilyEnum.Martial,
                                     0,
                                     null,
                                     WeaponWeightClassEnum.OneHanded,
                                     315,
                                     new ArrayList<Damage>(),
                                     2,
                                     1,
                                     new ArrayList<WeaponDamageTypeEnum>(),
                                     "Steel",
                                     true,
                                     false,
                                     1,
                                     SizeCategoryEnum.Medium,
                                     4,
                                     0,
                                      null);
    private Armor plate = new Armor("Plate Armor",
                                    1650,
                                    9,
                                    2,
                                    1,
                                    6,
                                    35,
                                    20,
                                    ArmorWeightCategoryEnum.Heavy,
                                    50,
                                    SizeCategoryEnum.Medium,
                                    false,
                                    null);
    private Shield tower = new Shield("Tower Shield",
                                      180,
                                      4,
                                      2,
                                      10,
                                      50,
                                      45,
                                      ShieldWeightCategoryEnum.Tower,
                                      SizeCategoryEnum.Medium,
                                      false,
                                      0,
                                      true,
                                      null);
    private List<IEquipment> TempEquipment = new ArrayList<IEquipment>();
    //endregion

    // TODO: Customize parameter argument names
    // TODO: Customize parameters
    private OnListFragmentInteractionListener mListener;
    private Animation click;
    private TextView mainHandMagicBonus;
    private TextView mainHandAbilities;
    private TextView mainHandEquipmentName;
    private TextView mainHandEquipmentLabel;
    private WeaponDetailView mainHandWeaponDetailView;
    private Button mainHandUnequipButton;
    private TextView offHandMagicBonus;
    private TextView offHandAbilities;
    private TextView offHandEquipmentName;
    private TextView offHandEquipmentLabel;
    private WeaponDetailView offHandWeaponDetailView;
    private Button offHandUnequipButton;
    private TextView armorMagicBonus;
    private TextView armorAbilities;
    private TextView armorEquipmentName;
    private TextView armorEquipmentLabel;
    private ProtectionDetailView armorProtectionDetailView;
    private Button armorUnequipButton;
    private TextView shieldMagicBonus;
    private TextView shieldAbilities;
    private TextView shieldEquipmentName;
    private TextView shieldEquipmentLabel;
    private ProtectionDetailView shieldProtectionDetailView;
    private Button shieldUnequipButton;

    private ArrayList<IProtection> currentPlayerArmor;
    
    public EquipmentReferenceFragment()
    {
        /**
         * Mandatory empty constructor for the fragment manager to instantiate the
         * fragment (e.g. upon screen orientation changes).
         */
    }

    @SuppressWarnings("unused")
    public static EquipmentReferenceFragment newInstance(int columnCount)
    {

        // TODO: Customize parameter initialization
        //We don't have any parameters yet, so we're not doing anything here
        EquipmentReferenceFragment fragment = new EquipmentReferenceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        ArrayList<WeaponDamageTypeEnum> typeList = new ArrayList<WeaponDamageTypeEnum>();
        typeList.add(WeaponDamageTypeEnum.Slashing);
        ArrayList<Damage> damageList = new ArrayList<Damage>();
        damageList.add(new Damage(1,8));
        tempEnchantments.add(flaming);
        sword.setEnchantments(tempEnchantments);
        sword.setDamageType(typeList);
        sword.setDamage(damageList);
        TempEquipment.add(sword);
        TempEquipment.add(plate);
        TempEquipment.add(tower);

        super.onCreate(savedInstanceState);
        currentPlayerArmor = (ArrayList<IProtection>)getArguments().getSerializable("PlayerArmor");
        int f = 5;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.equipment_fragment_view, container, false);
        Context context = rootView.getContext();

        mainHandMagicBonus = rootView.findViewById(R.id.MainHandMagicBonus);
        mainHandAbilities = rootView.findViewById(R.id.MainHandEquipmentAbilities);
        mainHandEquipmentName = rootView.findViewById(R.id.MainHandEquipmentName);
        mainHandEquipmentLabel = rootView.findViewById(R.id.MainHandEquipmentLabel);
        mainHandWeaponDetailView = rootView.findViewById(R.id.MainHandWeaponDetailView);
        mainHandUnequipButton = rootView.findViewById(R.id.MainHandEquipmentRowUnequipButton);
        offHandMagicBonus = rootView.findViewById(R.id.OffHandMagicBonus);
        offHandAbilities = rootView.findViewById(R.id.OffHandEquipmentAbilities);
        offHandEquipmentName = rootView.findViewById(R.id.OffHandEquipmentName);
        offHandEquipmentLabel = rootView.findViewById(R.id.OffHandEquipmentLabel);
        offHandWeaponDetailView = rootView.findViewById(R.id.OffHandWeaponDetailView);
        offHandUnequipButton = rootView.findViewById(R.id.OffHandEquipmentRowUnequipButton);
        armorMagicBonus = rootView.findViewById(R.id.ArmorMagicBonus);
        armorAbilities = rootView.findViewById(R.id.ArmorEquipmentAbilities);
        armorEquipmentName = rootView.findViewById(R.id.ArmorEquipmentName);
        armorEquipmentLabel = rootView.findViewById(R.id.ArmorEquipmentLabel);
        armorProtectionDetailView = rootView.findViewById(R.id.ArmorProtectionDetailView);
        armorUnequipButton = rootView.findViewById(R.id.ArmorEquipmentRowUnequipButton);
        shieldMagicBonus = rootView.findViewById(R.id.ShieldMagicBonus);
        shieldAbilities = rootView.findViewById(R.id.ShieldEquipmentAbilities);
        shieldEquipmentName = rootView.findViewById(R.id.ShieldEquipmentName);
        shieldEquipmentLabel = rootView.findViewById(R.id.ShieldEquipmentLabel);
        shieldProtectionDetailView = rootView.findViewById(R.id.ShieldProtectionDetailView);
        shieldUnequipButton = rootView.findViewById(R.id.ShieldEquipmentRowUnequipButton);

        //Set up the animations for clicking our category buttons
        click = AnimationUtils.loadAnimation(context, R.anim.roll_button_click);
        final Button armorAndWeaponsButton = rootView.findViewById(R.id.ArmorAndWeaponsButton);
        final Button wondrousItemsButton = rootView.findViewById(R.id.WondrousItemsButton);
        armorAndWeaponsButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                armorAndWeaponsButton.startAnimation(click);
            }
        }));

        wondrousItemsButton.setOnClickListener((new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                wondrousItemsButton.startAnimation(click);
            }
        }));

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
        void onListFragmentInteraction(IEquipment item);
    }

    private String CreateEnchantmentString(IWeapon weapon)
    {
        List<IWeaponEnchantment> enchantments = weapon.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(enchantments != null && enchantments.size() >= 1) {
            for (IWeaponEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

    private String CreateEnchantmentString(IArmor armor)
    {
        List<IArmorEnchantment> enchantments = armor.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(enchantments != null && enchantments.size() >= 1) {
            for (IArmorEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }

    private String CreateEnchantmentString(IShield shield)
    {
        List<IWeaponEnchantment> enchantments = shield.getEnchantments();
        StringBuilder enchantmentString = new StringBuilder();
        if(shield.getEnchantments() != null && enchantments.size() >= 1) {
            for (IWeaponEnchantment enchantment : enchantments) {
                enchantmentString.append(enchantment.getName()).append(" ");
            }
            return enchantmentString.toString();
        }
        else
        {
            return "None";
        }
    }
}
