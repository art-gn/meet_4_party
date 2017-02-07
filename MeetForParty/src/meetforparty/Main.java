/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetforparty;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        listUser Membres = new listUser();
        User test = new User("Lutin","1991-09-09","zob","homme");
        //System.out.println(test);
        int choix;
        
        Connect connection = new Connect();
        do{
            System.out.println("\n\n---MENU---");
            System.out.println("0. Quitter");
            System.out.println("1. Inscription");
            System.out.println("2. Connexion");
            System.out.println("3.Création Event");
            System.out.println("4.Afficher Event dispo");
            
            choix = new Scanner(System.in).nextInt();
            
            switch(choix){
                case 1:
                    System.out.println("--Nouvel Utilisateur--");
                    System.out.print("Pseudo : ");
                    String pseudo = new Scanner(System.in).nextLine();
                    System.out.print("Date de naissance (yyyy-mm-dd): ");
                    String birthDate = new Scanner(System.in).nextLine();
                    System.out.print("Mot de passe): ");
                    String password = new Scanner(System.in).nextLine();
                    System.out.print("Homme - Femme : ");
                    String sexe = new Scanner(System.in).nextLine();
                    connection.addUser(pseudo, birthDate, password, sexe);
                    break;
                case 2:
                    System.out.print("Pseudo : ");
                    String identifiant = new Scanner(System.in).nextLine();
                    System.out.print("Mot de passe): ");
                    String mdp = new Scanner(System.in).nextLine();
                    connection.login(identifiant,mdp);
                    break;
                case 3:
                    System.out.println("__NEW EVENT__");
                    System.out.println("Nom: ");
                    String nom= new Scanner(System.in).nextLine();
                    System.out.println("Date de la Partie");
                    String Date= new Scanner(System.in).nextLine();
                    System.out.println("Heure de la partie");
                    String heure= new Scanner(System.in).nextLine();
                    connection.addEvent(nom,Date,heure);
                    break;
                case 4:
                    System.out.println("___EVENT DISPO___");
                    connection.getEvents();
                    break;
                    
            }
        } while(choix != 0);
        connection.fermerConnexion();
    }
    
}
