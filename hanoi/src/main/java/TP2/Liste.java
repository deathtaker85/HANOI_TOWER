package TP2;

import java.util.ArrayList;

public class Liste {
   public ArrayList<Object> ma_liste = new ArrayList();
   private int position;
   private Object tmp;
   private int suivant;
   private int dernier;
   private int premier;
   private Object premier_element;
   private Object dernier_element;

   public Liste() {
      this.suivant = this.position + 1;
      this.position = 0;
      this.premier = 0;
   }

   public void premier() {
      System.out.println("on se positionne sur le premier élément de la liste");
      this.position = this.premier;
      this.setPremier_element(this.ma_liste.get(this.premier));
   }

   public Object suivant() {
      if (this.ma_liste.isEmpty()) {
         System.out.println("ERREUR, la liste est vide ");
         System.out.println(this.ma_liste);
      } else if (this.suivant == this.ma_liste.size()) {
         System.out.println("on est dejà à la fin de la liste ");
      } else if (this.ma_liste.size() == 1) {
         System.out.println("il n'y a qu'un seul element dans cette liste : ");
         System.out.println(this.ma_liste);
      } else {
         System.out.println("le suivant dans la liste juste apres " + this.ma_liste.get(this.position) + " est " + this.ma_liste.get(this.suivant));
      }

      this.position = this.suivant;
      return this.ma_liste.get(this.suivant);
   }

   public void dernier() {
      if (!this.ma_liste.isEmpty()) {
         this.dernier = this.ma_liste.size() - 1;
         this.setDernier_element(this.ma_liste.get(this.dernier));
         this.position = this.dernier;
      }

   }

   public Object supprimer() {
      if (this.ma_liste.isEmpty()) {
         System.out.println("il n'y a aucun element dans cette liste");
      } else {
         this.tmp = this.ma_liste.get(this.position);
         this.ma_liste.remove(this.position);
      }

      return this.tmp;
   }

   public void ajouter(Object element) {
      if (this.ma_liste.isEmpty()) {
         this.ma_liste.add(element);
      } else {
         this.ma_liste.add(this.position, element);
      }

   }

   public Object getPremier_element() {
      this.premier_element = this.ma_liste.get(this.premier);
      return this.premier_element;
   }

   public void setPremier_element(Object premier_element) {
      this.premier_element = premier_element;
   }

   public Object getDernier_element() {
      this.dernier_element = this.ma_liste.get(this.ma_liste.size() - 1);
      return this.dernier_element;
   }

   public void setDernier_element(Object dernier_element) {
      this.dernier_element = dernier_element;
   }
}