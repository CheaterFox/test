public class Shop extends SafeLocations{
    public Shop(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to shop! Choose an equipment from menu");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("-- SHOP MENU --");
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.println("Your choose: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3 ){
                System.out.println("Invalid value. Please choose again.");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Come again...");
                    showMenu = false;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("------ Weapons ------");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + ": < Price: " + w.getPrice() + " Damage: " + w.getDamage() + " >");
        }
        System.out.println("4 - Go back to shop menu");
    }
    public  void buyWeapon(){
        System.out.println("Please select a weapon");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length + 1){// + 1 is for going back to shop menu
            System.out.println("Invalid value. Please choose again.");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 4){
            Weapon selectedWeapon = Weapon.getWeaponByID(selectWeaponID);

            if (selectedWeapon != null){
                if (selectedWeapon.getPrice() > this.getPlayer().getGold()){
                    System.out.println("You don't have enough gold to buy this weapon");
                }
                else {
                    //purchase process
                    int balance = this.getPlayer().getGold() - selectedWeapon.getPrice();
                    this.getPlayer().setGold(balance);
                    System.out.println("You bought " + selectedWeapon.getName() + ".");
                    System.out.println("Your previous weapon is " + this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    System.out.println("Your new weapon is " + this.getPlayer().getInventory().getWeapon().getName());
                }
            }
        }
    }
    public void printArmor(){
        System.out.println("------ Armors ------");
        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + ": < Price : " + a.getPrice() + " Block : " + a.getBlock() + " >");
        }
        System.out.println("4 - Go back to shop menu");
    }
    public void buyArmor(){
        System.out.println("Please select an armor");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length + 1){ // + 1 is for going back to shop menu
            System.out.println("Invalid value. Please choose again.");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 4){
            Armor selectedArmor = Armor.getArmorByID(selectArmorID);

            if (selectedArmor != null){
                if (selectedArmor.getPrice() > this.getPlayer().getGold()){
                    System.out.println("You don't have enough gold to buy this armor");
                }
                else {
                    //purchase process
                    int balance = this.getPlayer().getGold() - selectedArmor.getPrice();
                    this.getPlayer().setGold(balance);
                    System.out.println("You bought " + selectedArmor.getName() + " Armor.");
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }

    }
}
