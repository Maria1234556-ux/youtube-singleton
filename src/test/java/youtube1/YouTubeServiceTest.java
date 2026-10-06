package com.example.youtube1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YouTubeServiceTest {

    @Test
    void testSameInstance() {
        YouTubeService service1 = YouTubeService.getInstance();
        YouTubeService service2 = YouTubeService.getInstance();

        // Vérifie qu'il s'agit exactement du même objet
        assertSame(service1, service2);
    }

    @Test
    void testSearchVideo() {
        YouTubeService service = YouTubeService.getInstance();
        String result = service.searchVideo("Java");

        assertEquals("Résultat pour : Java", result);
    }
}