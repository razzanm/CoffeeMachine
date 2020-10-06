package com.company;

import java.util.Scanner;
enum StatesofCoffemachine {
    CHOOSINGACTION,CHOOSINGVARIANTOFCOFFEE,ADDINGWATER,ADDINGMILK,ADDINGCOFFEEBEANS,ADDINGCUPS
}
 class CoffeeMachine1 {
     int water;
     int milk;
     int coffeeBeans;
     int cups;
     int money;
    public CoffeeMachine1() {
         water = 400;
         milk = 540;
         coffeeBeans = 120;
         cups = 9;
         money = 550;
    }

     public int getMoney() {
         return money;
     }

     public void setCoffeeBeans(int coffeeBeans) {
         this.coffeeBeans += coffeeBeans;
     }

     public void setCups(int cups) {
         this.cups += cups;
     }

     public void setMilk(int milk) {
         this.milk += milk;
     }

     public void setMoney(int money) {
         this.money = money;
     }

     public void setWater(int water) {
         this.water += water;
     }

     public void showStats() {
         System.out.println("The coffee machine has:");
         System.out.println(water + " of water");
         System.out.println(milk + " of milk");
         System.out.println(coffeeBeans + " of coffee beans");
         System.out.println(cups + " of disposable cups");
         System.out.println("$" + money + " of money");
     }
     public void makeEsoresso() {
         if (water < 250) {
             System.out.println("Sorry, not enough water!");
             return;
         } else if (coffeeBeans < 16) {
             System.out.println("Sorry, not enough coffee beans!");
             return;
         } else if (cups < 1) {
             System.out.println("Sorry, not enough cups!");
             return;
         }
         System.out.println("I have enough resources, making you a coffee!");
         water -= 250;
         coffeeBeans -= 16;
         cups--;
         money += 4;
     }

     public void makeLatte() {
         if (water < 350) {
             System.out.println("Sorry, not enough water!");
             return;
         } else if (coffeeBeans < 20) {
             System.out.println("Sorry, not enough coffee beans!");
             return;
         } else if (milk < 75) {
             System.out.println("Sorry, not enough milk!");
             return;
         } else if (cups < 1) {
             System.out.println("Sorry, not enough cups!");
             return;
         }
         System.out.println("I have enough resources, making you a coffee!");
         water -= 350;
         milk -= 75;
         coffeeBeans -= 20;
         cups--;
         money += 7;
     }

     public void makeCappuccino() {
         if (water < 200) {
             System.out.println("Sorry, not enough water!");
             return;
         } else if (coffeeBeans < 12) {
             System.out.println("Sorry, not enough coffee beans!");
             return;
         } else if (milk < 100) {
             System.out.println("Sorry, not enough milk!");
             return;
         } else if (cups < 1) {
             System.out.println("Sorry, not enough cups!");
             return;
         }
         System.out.println("I have enough resources, making you a coffee!");
         water -= 200;
         milk -= 100;
         cups--;
         coffeeBeans -= 12;
         money += 6;
     }
 }
public class CoffeeMachine {

   static StatesofCoffemachine statesofCoffemachine = StatesofCoffemachine.CHOOSINGACTION;
    static CoffeeMachine1 coffeeMachine1 = new CoffeeMachine1();
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (statesofCoffemachine == StatesofCoffemachine.CHOOSINGACTION) {
                System.out.println("Write action (buy, fill, take, remaining, exit):");
            }
            String userInput = scanner.nextLine();
            if (userInput.equals("exit")) {
                return;
            }
            CoffeeMachineController(userInput);
        }
    }
    static void CoffeeMachineController(String userinput) {
        if(statesofCoffemachine == StatesofCoffemachine.CHOOSINGACTION) {
            switch (userinput) {
                case "buy" :
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    statesofCoffemachine = StatesofCoffemachine.CHOOSINGVARIANTOFCOFFEE;
                    break;

                case "fill" :
                    System.out.println("Write how many ml of water do you want to add:");
                    statesofCoffemachine = StatesofCoffemachine.ADDINGWATER;
                    break;
                case "take" :
                    System.out.println("I gave you " + coffeeMachine1.getMoney());
                    coffeeMachine1.setMoney(0);
                    break;

                case "remaining" :
                    coffeeMachine1.showStats();
                    break;

                case "exit":
                    return;
                default:
                    System.out.println("Enter the valid entry");
            }
        }else if(statesofCoffemachine == StatesofCoffemachine.ADDINGWATER) {
            coffeeMachine1.setWater(Integer.parseInt(userinput));
            System.out.println("Write how many ml of milk do you want to add:");
            statesofCoffemachine = StatesofCoffemachine.ADDINGMILK;
        }else if(statesofCoffemachine == StatesofCoffemachine.ADDINGMILK) {
            coffeeMachine1.setMilk(Integer.parseInt(userinput));
            System.out.println("Write how many grams of coffee beans do you want to add:");
            statesofCoffemachine = StatesofCoffemachine.ADDINGCOFFEEBEANS;
        }else if(statesofCoffemachine == StatesofCoffemachine.ADDINGCOFFEEBEANS) {
            coffeeMachine1.setCoffeeBeans(Integer.parseInt(userinput));
            System.out.println("Write how many disposable cups of coffee do you want to add:");
            statesofCoffemachine = StatesofCoffemachine.ADDINGCUPS;
        }else if(statesofCoffemachine == StatesofCoffemachine.ADDINGCUPS) {
            coffeeMachine1.setCups(Integer.parseInt(userinput));
            statesofCoffemachine = StatesofCoffemachine.CHOOSINGACTION;
        }else if(statesofCoffemachine == StatesofCoffemachine.CHOOSINGVARIANTOFCOFFEE) {
            switch (userinput) {
                        case "1":
                            coffeeMachine1.makeEsoresso();
                            statesofCoffemachine = StatesofCoffemachine.CHOOSINGACTION;
                            break;
                        case "2":
                            coffeeMachine1.makeLatte();
                            statesofCoffemachine = StatesofCoffemachine.CHOOSINGACTION;
                            break;
                        case "3":
                            coffeeMachine1.makeCappuccino();
                            statesofCoffemachine = StatesofCoffemachine.CHOOSINGACTION;
                            break;
                        default:
                    }
        }
    }
}
