package service;

import database.Database;
import entity.Item;
import exception.ItemNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImp implements ItemService{




    // ItemService icerisinde tanilanmis govdesiz tum methodlarin implementation unu bu class da yapacaksiniz...
    // Class ismindeki KIRMIZI ikaza giderseniz 'implement mothods' secenegini goreceksiniz... Onu secin ve baslayin...





    // GetAllItems methodu Database e gidip oradan butun item lari alir ve bir List olarak return eder...

    @Override
    public List<Item> getAllItems() {

        return Database.items;
    }




    // getItemById methodu parametre olarak aldigi id ile Database de boyle bir item var mi diye kontrol eder,
    // yoksa, ItemNotFound exception firlatir, varsa ilgili item i return eder...


    @Override
    public Item getItemById(int id) throws ItemNotFoundException {
        for(Item item:Database.items){
            if(item.getId()==id){
                return item;
            }
        }
         throw new ItemNotFoundException("boyle bir urun stoklarimizda mevcut degilfir");
    }

    // addItem methodu, parametre olarak aldigi item i Database deki items listesine ekler...@Override
    public void addItem(Item item) {
       Database. items.add(item);
    }



    // deleteItemById methodu parametre olarak aldigi id ile Database de o urunu arar, bulamazsa ItemnotFound exception firlatir
    // ilgili item mevcut ise onu Database list inden siler...


    @Override
    public void deleteItemById(int id) throws ItemNotFoundException {
              for(Item item:Database.items)  {
                  if(item.getId()==id){
                      Database.items.remove(id);break;
                  }
                throw new ItemNotFoundException("Boyle br urun stoklarimizda mevcut degildir");
              }
    }





    // updateItem methodu parametre olarak aldigi Item i Database de arar, yoksa ItemNotFound exception firlatir,
    // Varsa Datalase deki items listesinden silip, guncel halini Database List ine ekler...


    @Override
    public void updateItem(Item item) throws ItemNotFoundException {

        for(Item item1:Database.items){
            if(item1.getId()==item.getId()){
              Database. items.remove(item1);
               addItem(item);
            }

        }
        throw new ItemNotFoundException(" Boyle bir urun stoklarimizda mevcur degilodir ");
    }





}
