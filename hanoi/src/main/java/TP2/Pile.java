 package TP2;

public class Pile {
   public Liste lt2 = new Liste();

   protected void Empiler(Object elements) {
      this.lt2.dernier();
      this.lt2.ajouter(elements);
   }

   protected Object Depiler() {
      this.lt2.dernier();
      return this.lt2.supprimer();
   }
}
    