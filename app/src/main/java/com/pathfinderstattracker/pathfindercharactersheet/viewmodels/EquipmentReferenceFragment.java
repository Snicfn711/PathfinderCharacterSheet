package com.pathfinderstattracker.pathfindercharactersheet.viewmodels;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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
import com.pathfinderstattracker.pathfindercharactersheet.database.PathfinderRepository;
import com.pathfinderstattracker.pathfindercharactersheet.models.SizeCategoryEnum;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.IPlayerCharacter;
import com.pathfinderstattracker.pathfindercharactersheet.models.characters.PlayerCharacter;
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
import com.pathfinderstattracker.pathfindercharactersheet.tools.Dialogs.EquipMundaneItemDialog;
import com.pathfinderstattracker.pathfindercharactersheet.tools.UpdateFragmentInterface;
import com.pathfinderstattracker.pathfindercharactersheet.tools.VisibilitySwitcher;
import com.pathfinderstattracker.pathfindercharactersheet.views.ProtectionDetailView;
import com.pathfinderstattracker.pathfindercharactersheet.views.WeaponDetailView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EquipmentReferenceFragment extends Fragment implements UpdateFragmentInterface
{
    private OnListFragmentInteractionListener mListener;
    private OnItemEquippedListener itemEquippedListener;
    private Animation click;
    private PathfinderRepository repository;

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

    private static final int EQUIP_ITEM = 1;

    private ArrayList<IEquipment> currentEquipmentInventory = new ArrayList<>();
    //We want to implement some logic for checking if an item is valid to equip so we need to keep track of not just what's in our inventory, but also what's already equipped
    private ArrayList<IEquipment> currentlyEquippedItems = new ArrayList<>();
    private IArmor currentlyEquippedArmor;
    private IShield currentlyEquippedShield;
    private IPlayerCharacter currentPlayerCharacter;
    
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
        super.onCreate(savedInstanceState);
        repository = new PathfinderRepository(this.getActivity().getApplication());
        currentlyEquippedItems = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        Bundle bundle = getArguments();
        if(bundle.containsKey("CurrentEquipmentInventory"))
        {
            currentEquipmentInventory = (ArrayList<IEquipment>)bundle.getSerializable("CurrentEquipmentInventory");
        }
        if(bundle.containsKey("PlayerCharacter"))
        {
            currentPlayerCharacter = (PlayerCharacter)bundle.get("PlayerCharacter");
            if(currentPlayerCharacter.getEquipment() != null)
            {
                currentlyEquippedItems.clear();
                currentlyEquippedItems.addAll(currentPlayerCharacter.getEquipment());
            }
        }

        //We don't want to constantly iterate through the list of currently equipped items when we're checking if specific slots are filled,
        //So we'll break down the list here.
        for(IEquipment equipment : currentlyEquippedItems)
        {
            if(equipment instanceof IArmor)
            {
                currentlyEquippedArmor = (IArmor)equipment;
            }
            if(equipment instanceof IShield)
            {
                currentlyEquippedShield = (IShield)equipment;
            }
        }

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

        BindViews();

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
        if(context instanceof OnItemEquippedListener)
        {
            itemEquippedListener = (OnItemEquippedListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString()
                    +" must implement OnItemEquippedListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void Update(Bundle args)
    {
        if(args.containsKey("PlayerCharacter"))
        {
            currentPlayerCharacter = (IPlayerCharacter)args.getSerializable("PlayerCharacter");
            if(currentPlayerCharacter.getEquipment() != null)
            {
                currentlyEquippedItems.clear();
                currentlyEquippedItems.addAll(currentPlayerCharacter.getEquipment());
            }
            //We don't want to constantly iterate through the list of currently equipped items when we're checking if specific slots are filled,
            //So we'll break down the list here.
            for(IEquipment equipment : currentlyEquippedItems)
            {
                if(equipment instanceof IArmor)
                {
                    currentlyEquippedArmor = (IArmor)equipment;
                }
                if(equipment instanceof IShield)
                {
                    currentlyEquippedShield = (IShield)equipment;
                }
            }
        }
        if(args.containsKey("CurrentEquipmentInventory"))
        {
            currentEquipmentInventory = (ArrayList<IEquipment>)args.getSerializable("CurrentEquipmentInventory");
        }

        BindViews();
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

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        switch(requestCode)
        {
            case EQUIP_ITEM:
                if (resultCode == Activity.RESULT_OK)
                {
                    IEquipment itemToEquip= (IEquipment) data.getExtras().getSerializable("ItemToEquip");
                    repository.equipItem(itemToEquip, currentPlayerCharacter.getPlayerCharacterID());
                    itemEquippedListener.onItemEquipped(itemToEquip);
                }
                break;
        }
    }

    //region Private Methods
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
    
    private void OpenEquipItemDialog(String titleString, ArrayList<IEquipment> relevantEquipmentInventory)
    {
        Bundle args = new Bundle();
        args.putSerializable("CurrentRelevantEquipmentInventory", relevantEquipmentInventory);
        args.putSerializable("CurrentlyEquippedItems", currentlyEquippedItems);
        args.putSerializable("TitleString", titleString);

        EquipMundaneItemDialog equipMundaneItemDialog = new EquipMundaneItemDialog();
        equipMundaneItemDialog.setArguments(args);

        equipMundaneItemDialog.setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        equipMundaneItemDialog.setTargetFragment(this, EQUIP_ITEM);
        equipMundaneItemDialog.show(this.getFragmentManager(),"Equip Item");
    }
    //endregion

    public interface OnItemEquippedListener
    {
        void onItemEquipped(IEquipment itemEquipped);
    }

    private void BindViews()
    {
        if(currentlyEquippedArmor != null)
        {
            armorEquipmentName.setText(currentlyEquippedArmor.getName());
            armorEquipmentName.setVisibility(View.VISIBLE);

            if(currentlyEquippedArmor.getEnchantments() != null)
            {
                armorAbilities.setVisibility(View.VISIBLE);
                armorAbilities.setText(CreateEnchantmentString(currentlyEquippedArmor));
            }

            if(currentlyEquippedArmor.getMagicBonus() != 0)
            {
                armorMagicBonus.setVisibility(View.VISIBLE);
                armorMagicBonus.setText(Integer.toString(currentlyEquippedArmor.getMagicBonus()));
            }

            armorProtectionDetailView.setValues(currentlyEquippedArmor);

            armorEquipmentLabel.setOnClickListener((new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(currentlyEquippedArmor.getEnchantments() != null)
                    {
                        VisibilitySwitcher.SwitchVisibility(armorAbilities);
                    }
                    VisibilitySwitcher.SwitchVisibility(armorEquipmentName);
                    if(currentlyEquippedArmor.getMagicBonus() != 0)
                    {
                        VisibilitySwitcher.SwitchVisibility(armorMagicBonus);
                    }
                    VisibilitySwitcher.SwitchVisibility(armorProtectionDetailView);
                    VisibilitySwitcher.SwitchVisibility(armorUnequipButton);
                }
            }));
        }
        else if(currentlyEquippedArmor == null)
        {
            armorEquipmentLabel.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    ArrayList<IEquipment> relevantEquipmentInventory = new ArrayList<>();
                    for(IEquipment equipment : currentEquipmentInventory)
                    {
                        if(equipment instanceof IArmor)
                        {
                            relevantEquipmentInventory.add(equipment);
                        }
                    }
                    OpenEquipItemDialog("Equip Armor", relevantEquipmentInventory);
                    return true;
                }
            });
        }

        if(currentlyEquippedShield != null)
        {
            shieldEquipmentName.setVisibility(View.VISIBLE);
            shieldEquipmentName.setText(currentlyEquippedShield.getName());

            if(currentlyEquippedShield.getEnchantments() != null)
            {
                shieldAbilities.setVisibility(View.VISIBLE);
                shieldAbilities.setText(CreateEnchantmentString(currentlyEquippedShield));
            }

            if(currentlyEquippedShield.getMagicBonus() != 0)
            {
                shieldMagicBonus.setVisibility(View.VISIBLE);
                shieldMagicBonus.setText(Integer.toString(currentlyEquippedShield.getMagicBonus()));
            }

            shieldProtectionDetailView.setValues(currentlyEquippedShield);

            shieldEquipmentLabel.setOnClickListener((new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    if(currentlyEquippedShield.getEnchantments() != null)
                    {
                        VisibilitySwitcher.SwitchVisibility(shieldAbilities);
                    }
                    VisibilitySwitcher.SwitchVisibility(shieldEquipmentName);
                    if(currentlyEquippedShield.getMagicBonus() != 0)
                    {
                        VisibilitySwitcher.SwitchVisibility(shieldMagicBonus);
                    }
                    VisibilitySwitcher.SwitchVisibility(shieldProtectionDetailView);
                    VisibilitySwitcher.SwitchVisibility(shieldUnequipButton);
                }
            }));
        }
        else if(currentlyEquippedShield == null)
        {
            shieldEquipmentLabel.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    ArrayList<IEquipment> relevantEquipmentInventory = new ArrayList<>();
                    for (IEquipment equipment : currentEquipmentInventory)
                    {
                        if (equipment instanceof IShield)
                        {
                            relevantEquipmentInventory.add(equipment);
                        }
                    }
                    OpenEquipItemDialog("Equip Shield", relevantEquipmentInventory);
                    return true;
                }
            });
        }
    }
}
