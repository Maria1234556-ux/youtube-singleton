package com.example.youtube1;

public class YouTubeService {

    // Constructeur privé pour empêcher l'instanciation directe
    private YouTubeService() {
        // Protection contre la réflexion (Reflection API)
        if (Holder.INSTANCE != null) {
            throw new IllegalStateException("Le Singleton est déjà instancié.");
        }
    }

    // Classe interne statique chargée uniquement lors de l'appel à getInstance()
    private static class Holder {
        private static final YouTubeService INSTANCE = new YouTubeService();
    }

    // Point d'accès global au Singleton
    public static YouTubeService getInstance() {
        return Holder.INSTANCE;
    }

    // Méthode métier exemple : recherche de vidéo
    public String searchVideo(String query) {
        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("La recherche ne peut pas être vide.");
        }
        return "Résultat pour : " + query;
    }

    // Méthode métier exemple : récupération de statut
    public boolean isConnected() {
        return true;
    }
}
