package com.example.youtube1;

public class Main {
    public static void main(String[] args) {
        // Récupération de l'instance unique
        YouTubeService service = YouTubeService.getInstance();

        // Appel des méthodes métier
        if (service.isConnected()) {
            String result = service.searchVideo("Tutoriels Java");
            System.out.println(result);
        }

        // Vérification de la même référence
        YouTubeService autreService = YouTubeService.getInstance();
        System.out.println("Est-ce la même instance ? " + (service == autreService));
    }
}