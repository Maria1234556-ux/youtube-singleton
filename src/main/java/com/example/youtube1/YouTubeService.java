package com.example.youtube1;

public class YouTubeService {

    // 1. Instance unique créée dès le chargement de la classe
    private static final YouTubeService INSTANCE = new YouTubeService();

    // 2. Constructeur privé pour interdire le "new"
    private YouTubeService() {
    }

    // 3. Méthode publique pour récupérer l'instance
    public static YouTubeService getInstance() {
        return INSTANCE;
    }

    // Méthode métier basique
    public String searchVideo(String query) {
        return "Résultat pour : " + query;
    }
}
