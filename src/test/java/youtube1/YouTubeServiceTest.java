package com.example.youtube1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class YouTubeServiceTest {

    @Test
    @DisplayName("getInstance() doit toujours retourner la même instance")
    void shouldReturnSameInstance() {
        YouTubeService instance1 = YouTubeService.getInstance();
        YouTubeService instance2 = YouTubeService.getInstance();

        assertNotNull(instance1, "L'instance ne doit pas être nulle");
        assertSame(instance1, instance2, "Les deux références doivent pointer vers le même objet");
    }

    @Test
    @DisplayName("Le constructeur ne doit pas être accessible via la réflexion")
    void shouldPreventReflectionInstantiation() throws Exception {
        YouTubeService instance = YouTubeService.getInstance();

        Constructor<YouTubeService> constructor = YouTubeService.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        InvocationTargetException exception = assertThrows(
                InvocationTargetException.class,
                constructor::newInstance,
                "L'instanciation via la réflexion doit échouer"
        );

        assertTrue(exception.getCause() instanceof IllegalStateException);
        assertEquals("Le Singleton est déjà instancié.", exception.getCause().getMessage());
    }

    @Test
    @DisplayName("searchVideo doit retourner le résultat attendu")
    void shouldSearchVideoSuccessfully() {
        YouTubeService service = YouTubeService.getInstance();
        String result = service.searchVideo("Java Tutorials");

        assertEquals("Résultat pour : Java Tutorials", result);
    }

    @Test
    @DisplayName("searchVideo doit lever une exception si la requête est invalide")
    void shouldThrowExceptionWhenSearchQueryIsEmpty() {
        YouTubeService service = YouTubeService.getInstance();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.searchVideo("  "),
                "Une requête vide ou nulle doit lever une IllegalArgumentException"
        );
    }
}