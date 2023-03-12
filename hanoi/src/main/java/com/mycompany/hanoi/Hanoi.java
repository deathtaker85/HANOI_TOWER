package com.mycompany.hanoi;

import TP2.pileEntier;
import java.util.Scanner;

public class Hanoi {
   public pileEntier H_1 = new pileEntier();
   public pileEntier H_2 = new pileEntier();
   public pileEntier H_3 = new pileEntier();
   public int mouvements;
   public int n1;
   public int dernier;
   public int nombre_disques;
   Scanner sc;

   public Hanoi() {
      this.sc = new Scanner(System.in);
      this.n1 = 0;
      this.mouvements = 0;
      this.dernier = 0;
   }
   
   public static void main(String [] args){
       Hanoi ha = new Hanoi();
       ha.nombre_de_disques();
       ha.remplissage();
       ha.deplacement_hanoi(ha.nombre_disques, ha.H_1, ha.H_2, ha.H_3);
   }

   public void nombre_de_disques() {
      System.out.println("Entrer le nombre de disque avec lesqueles vous souhaitez jouer");

      do {
         this.nombre_disques = this.sc.nextInt();
         if (this.nombre_disques <= 0) {
            System.out.println("veuiller entrer une valeur correcte, c'est à dire  positive non nulle SVP!!!");
         }
      } while(this.nombre_disques <= 0);

      System.out.println("vous aller jouer avec " + this.nombre_disques + " disques");
   }

   public void remplissage() {
      for(int i = this.nombre_disques + 1; i >= 1; --i) {
         this.H_1.Empiler(i);
      }

      this.H_1.Depiler();
      System.out.println("la tour de depart est H_1 " + this.H_1.lt2.ma_liste);
      System.out.println("les deux autres listes H_2 et H_3 sont les suivantes ");
      System.out.println(this.H_2.lt2.ma_liste);
      System.out.println(this.H_3.lt2.ma_liste);
      System.out.println(" ");
   }

   public void deplacement_hanoi(int nb, pileEntier depart, pileEntier intermediare, pileEntier finish) {
      System.out.println("|--------------------------------DEBUT DU JEU DES TOURS DE HANOI-------------------------------------|");
      System.out.println(" ");

      while(true) {
         while(finish.lt2.ma_liste.size() != nb) {
            if (nb == 1) {
               System.out.println("H_1 -----> H_3");
               finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
               depart.Depiler();
               this.mouvements += 2;
            }

            if (nb % 2 == 0) {
               if (this.n1 == 0) {
                  System.out.println("H_1 -----> H_2");
                  intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                  depart.Depiler();
                  System.out.println("H_1 -----> H_3");
                  finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                  this.dernier = (Integer)finish.lt2.getDernier_element();
                  depart.Depiler();
                  ++this.n1;
                  System.out.println(this.H_1.lt2.ma_liste);
                  System.out.println(this.H_2.lt2.ma_liste);
                  System.out.println(this.H_3.lt2.ma_liste);
                  System.out.println(" ");
                  ++this.mouvements;
                  continue;
               }

               if (!depart.lt2.ma_liste.isEmpty() && (Integer)depart.lt2.getDernier_element() != this.dernier) {
                  if ((Integer)depart.lt2.getDernier_element() % 2 != 0) {
                     if (intermediare.lt2.ma_liste.isEmpty() || (Integer)intermediare.lt2.getDernier_element() % 2 == 0 && (Integer)intermediare.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                        System.out.println("H_1 -----> H_2");
                        intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                        this.dernier = (Integer)depart.lt2.getDernier_element();
                        depart.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }

                     if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                        System.out.println("H_1 -----> H_3");
                        finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                        this.dernier = (Integer)depart.lt2.getDernier_element();
                        depart.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }
                  }

                  if ((Integer)depart.lt2.getDernier_element() % 2 == 0) {
                     if (intermediare.lt2.ma_liste.isEmpty()) {
                        System.out.println("H_1 -----> H_2");
                        intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                        this.dernier = (Integer)depart.lt2.getDernier_element();
                        depart.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }

                     if ((Integer)intermediare.lt2.getDernier_element() % 2 != 0 && (Integer)intermediare.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                        System.out.println("H_1 -----> H_2");
                        intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                        this.dernier = (Integer)depart.lt2.getDernier_element();
                        depart.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }

                     if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 != 0 && (Integer)finish.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                        System.out.println("H_1 -----> H_3");
                        finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                        this.dernier = (Integer)depart.lt2.getDernier_element();
                        depart.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }
                  }
               }

               if (!intermediare.lt2.ma_liste.isEmpty() && (Integer)intermediare.lt2.getDernier_element() != this.dernier) {
                  if ((Integer)intermediare.lt2.getDernier_element() % 2 != 0) {
                     if (depart.lt2.ma_liste.isEmpty() && (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                        System.out.println("H_2 -----> H_3");
                        finish.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                        this.dernier = (Integer)intermediare.lt2.getDernier_element();
                        intermediare.Depiler();
                        ++this.mouvements;
                        continue;
                     }

                     if (depart.lt2.ma_liste.isEmpty() || (Integer)depart.lt2.getDernier_element() % 2 == 0 && (Integer)depart.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                        System.out.println("H_2 -----> H_1");
                        depart.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                        this.dernier = (Integer)intermediare.lt2.getDernier_element();
                        intermediare.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }

                     if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                        System.out.println("H_2 -----> H_3");
                        finish.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                        this.dernier = (Integer)intermediare.lt2.getDernier_element();
                        intermediare.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }
                  }

                  if ((Integer)intermediare.lt2.getDernier_element() % 2 == 0) {
                     if (depart.lt2.ma_liste.isEmpty() || (Integer)depart.lt2.getDernier_element() % 2 != 0 && (Integer)depart.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                        System.out.println("H_2 -----> H_1");
                        depart.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                        this.dernier = (Integer)intermediare.lt2.getDernier_element();
                        intermediare.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }

                     if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 != 0 && (Integer)finish.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                        System.out.println("H_2 -----> H_3");
                        finish.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                        this.dernier = (Integer)intermediare.lt2.getDernier_element();
                        intermediare.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }
                  }
               }

               if (!finish.lt2.ma_liste.isEmpty() && (Integer)finish.lt2.getDernier_element() != this.dernier) {
                  if ((Integer)finish.lt2.getDernier_element() % 2 != 0) {
                     label450: {
                        if (!depart.lt2.ma_liste.isEmpty() && ((Integer)depart.lt2.getDernier_element() % 2 != 0 || (Integer)depart.lt2.getDernier_element() <= (Integer)finish.lt2.getDernier_element())) {
                           if (!intermediare.lt2.ma_liste.isEmpty() && ((Integer)intermediare.lt2.getDernier_element() % 2 != 0 || (Integer)intermediare.lt2.getDernier_element() <= (Integer)finish.lt2.getDernier_element())) {
                              break label450;
                           }

                           System.out.println("H_3 -----> H_2");
                           intermediare.lt2.ma_liste.add(finish.lt2.getDernier_element());
                           this.dernier = (Integer)finish.lt2.getDernier_element();
                           finish.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }

                        System.out.println("H_3 -----> H_1");
                        depart.lt2.ma_liste.add(finish.lt2.getDernier_element());
                        this.dernier = (Integer)finish.lt2.getDernier_element();
                        finish.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }
                  }

                  if ((Integer)finish.lt2.getDernier_element() % 2 == 0) {
                     if (depart.lt2.ma_liste.isEmpty() || (Integer)depart.lt2.getDernier_element() % 2 != 0 && (Integer)depart.lt2.getDernier_element() > (Integer)finish.lt2.getDernier_element()) {
                        System.out.println("H_3 -----> H_1");
                        depart.lt2.ma_liste.add(finish.lt2.getDernier_element());
                        this.dernier = (Integer)finish.lt2.getDernier_element();
                        finish.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }

                     if (intermediare.lt2.ma_liste.isEmpty() || (Integer)intermediare.lt2.getDernier_element() % 2 != 0 && (Integer)intermediare.lt2.getDernier_element() > (Integer)finish.lt2.getDernier_element()) {
                        System.out.println("H_3 -----> H_2");
                        intermediare.lt2.ma_liste.add(finish.lt2.getDernier_element());
                        this.dernier = (Integer)finish.lt2.getDernier_element();
                        finish.Depiler();
                        System.out.println(this.H_1.lt2.ma_liste);
                        System.out.println(this.H_2.lt2.ma_liste);
                        System.out.println(this.H_3.lt2.ma_liste);
                        System.out.println(" ");
                        ++this.mouvements;
                        continue;
                     }
                  }
               }
            }

            if (nb % 2 != 0 && nb != 1) {
               if (this.n1 == 0) {
                  System.out.println("H_1 -----> H_3");
                  finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                  depart.Depiler();
                  System.out.println("H_1 -----> H_2");
                  intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                  this.dernier = (Integer)intermediare.lt2.getDernier_element();
                  depart.Depiler();
                  ++this.n1;
                  System.out.println(this.H_1.lt2.ma_liste);
                  System.out.println(this.H_2.lt2.ma_liste);
                  System.out.println(this.H_3.lt2.ma_liste);
                  System.out.println(" ");
                  this.mouvements += 2;
               } else {
                  if (!depart.lt2.ma_liste.isEmpty() && (Integer)depart.lt2.getDernier_element() != this.dernier) {
                     if ((Integer)depart.lt2.getDernier_element() % 2 != 0) {
                        if (intermediare.lt2.ma_liste.isEmpty() && (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                           System.out.println("H_1 -----> H_3");
                           finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                           this.dernier = (Integer)depart.lt2.getDernier_element();
                           depart.Depiler();
                           ++this.mouvements;
                           continue;
                        }

                        if (intermediare.lt2.ma_liste.isEmpty() || (Integer)intermediare.lt2.getDernier_element() % 2 == 0 && (Integer)intermediare.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                           System.out.println("H_1 -----> H_2");
                           intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                           this.dernier = (Integer)depart.lt2.getDernier_element();
                           depart.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }

                        if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                           System.out.println("H_1 -----> H_3");
                           finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                           this.dernier = (Integer)depart.lt2.getDernier_element();
                           depart.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }
                     }

                     if ((Integer)depart.lt2.getDernier_element() % 2 == 0) {
                        if (intermediare.lt2.ma_liste.isEmpty()) {
                           System.out.println("H_1 -----> H_2");
                           intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                           this.dernier = (Integer)depart.lt2.getDernier_element();
                           depart.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }

                        if ((Integer)intermediare.lt2.getDernier_element() % 2 != 0 && (Integer)intermediare.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                           System.out.println("H_1 -----> H_2");
                           intermediare.lt2.ma_liste.add(depart.lt2.getDernier_element());
                           this.dernier = (Integer)depart.lt2.getDernier_element();
                           depart.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }

                        if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 != 0 && (Integer)finish.lt2.getDernier_element() > (Integer)depart.lt2.getDernier_element()) {
                           System.out.println("H_1 -----> H_3");
                           finish.lt2.ma_liste.add(depart.lt2.getDernier_element());
                           this.dernier = (Integer)depart.lt2.getDernier_element();
                           depart.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }
                     }
                  }

                  if (!finish.lt2.ma_liste.isEmpty() && (Integer)finish.lt2.getDernier_element() != this.dernier) {
                     if ((Integer)finish.lt2.getDernier_element() % 2 != 0) {
                        label453: {
                           if (!depart.lt2.ma_liste.isEmpty() && ((Integer)depart.lt2.getDernier_element() % 2 != 0 || (Integer)depart.lt2.getDernier_element() <= (Integer)finish.lt2.getDernier_element())) {
                              if (!intermediare.lt2.ma_liste.isEmpty() && ((Integer)intermediare.lt2.getDernier_element() % 2 != 0 || (Integer)intermediare.lt2.getDernier_element() <= (Integer)finish.lt2.getDernier_element())) {
                                 break label453;
                              }

                              System.out.println("H_3 -----> H_2");
                              intermediare.lt2.ma_liste.add(finish.lt2.getDernier_element());
                              this.dernier = (Integer)finish.lt2.getDernier_element();
                              finish.Depiler();
                              System.out.println(this.H_1.lt2.ma_liste);
                              System.out.println(this.H_2.lt2.ma_liste);
                              System.out.println(this.H_3.lt2.ma_liste);
                              System.out.println(" ");
                              ++this.mouvements;
                              continue;
                           }

                           System.out.println("H_3 -----> H_1");
                           depart.lt2.ma_liste.add(finish.lt2.getDernier_element());
                           this.dernier = (Integer)finish.lt2.getDernier_element();
                           finish.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }
                     }

                     if ((Integer)finish.lt2.getDernier_element() % 2 == 0) {
                        label454: {
                           if (!depart.lt2.ma_liste.isEmpty() && ((Integer)depart.lt2.getDernier_element() % 2 == 0 || (Integer)depart.lt2.getDernier_element() <= (Integer)finish.lt2.getDernier_element())) {
                              if (!intermediare.lt2.ma_liste.isEmpty() && ((Integer)intermediare.lt2.getDernier_element() % 2 == 0 || (Integer)intermediare.lt2.getDernier_element() <= (Integer)finish.lt2.getDernier_element())) {
                                 break label454;
                              }

                              System.out.println("H_3 -----> H_2");
                              intermediare.lt2.ma_liste.add(finish.lt2.getDernier_element());
                              this.dernier = (Integer)finish.lt2.getDernier_element();
                              finish.Depiler();
                              System.out.println(this.H_1.lt2.ma_liste);
                              System.out.println(this.H_2.lt2.ma_liste);
                              System.out.println(this.H_3.lt2.ma_liste);
                              System.out.println(" ");
                              ++this.mouvements;
                              continue;
                           }

                           System.out.println("H_3 -----> H_1");
                           depart.lt2.ma_liste.add(finish.lt2.getDernier_element());
                           this.dernier = (Integer)finish.lt2.getDernier_element();
                           finish.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }
                     }
                  }

                  if (!intermediare.lt2.ma_liste.isEmpty() && (Integer)intermediare.lt2.getDernier_element() != this.dernier) {
                     if ((Integer)intermediare.lt2.getDernier_element() % 2 != 0) {
                        if (depart.lt2.ma_liste.isEmpty() && (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                           System.out.println("H_2 -----> H_3");
                           finish.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                           this.dernier = (Integer)intermediare.lt2.getDernier_element();
                           intermediare.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }

                        if (depart.lt2.ma_liste.isEmpty() || (Integer)depart.lt2.getDernier_element() % 2 == 0 && (Integer)depart.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                           System.out.println("H_2 -----> H_1");
                           depart.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                           this.dernier = (Integer)intermediare.lt2.getDernier_element();
                           intermediare.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }

                        if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 == 0 && (Integer)finish.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                           System.out.println("H_2 -----> H_3");
                           finish.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                           this.dernier = (Integer)intermediare.lt2.getDernier_element();
                           intermediare.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                           continue;
                        }
                     }

                     if ((Integer)intermediare.lt2.getDernier_element() % 2 == 0) {
                        if (!depart.lt2.ma_liste.isEmpty() && ((Integer)depart.lt2.getDernier_element() % 2 == 0 || (Integer)depart.lt2.getDernier_element() <= (Integer)intermediare.lt2.getDernier_element())) {
                           if (finish.lt2.ma_liste.isEmpty() || (Integer)finish.lt2.getDernier_element() % 2 != 0 && (Integer)finish.lt2.getDernier_element() > (Integer)intermediare.lt2.getDernier_element()) {
                              System.out.println("H_2 -----> H_3");
                              finish.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                              this.dernier = (Integer)intermediare.lt2.getDernier_element();
                              intermediare.Depiler();
                              System.out.println(this.H_1.lt2.ma_liste);
                              System.out.println(this.H_2.lt2.ma_liste);
                              System.out.println(this.H_3.lt2.ma_liste);
                              System.out.println(" ");
                              ++this.mouvements;
                           }
                        } else {
                           System.out.println("H_2 -----> H_1");
                           depart.lt2.ma_liste.add(intermediare.lt2.getDernier_element());
                           this.dernier = (Integer)intermediare.lt2.getDernier_element();
                           intermediare.Depiler();
                           System.out.println(this.H_1.lt2.ma_liste);
                           System.out.println(this.H_2.lt2.ma_liste);
                           System.out.println(this.H_3.lt2.ma_liste);
                           System.out.println(" ");
                           ++this.mouvements;
                        }
                     }
                  }
               }
            }
         }

         System.out.println(" ");
         System.out.println("|---------------------------------------------FIN DU JEU-----------------------------------------------|");
         System.out.println(" ");
         System.out.println(this.H_1.lt2.ma_liste);
         System.out.println(this.H_2.lt2.ma_liste);
         System.out.println(this.H_3.lt2.ma_liste);
         System.out.println("FIN DU CODE, LE JEU C'EST TERMINÉ EN " + this.mouvements + " COUPS");
         System.out.println("VOUS POUVEZ OBSERVER LES DIFFERENTS RESULTATS PLUS HAUT");
         return;
      }
   }
}
    