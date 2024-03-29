package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

    /**
     * Testuje metodu {@link Svatky#vratKdyMaSvatek(String)}
     */
    @Test
    void kdyMaSvatek() {
        Svatky svatky = new Svatky();
        assertEquals(MonthDay.of(5, 18), svatky.vratKdyMaSvatek("Nataša"));
        assertNull(svatky.vratKdyMaSvatek("Eva"));
    }

    /**
     * Testuje metodu {@link Svatky#jeVSeznamu(String)}
     */
    @Test
    void jeVSeznamu() {
        //testuje, že najde v seznamu existující jméno a nenajde neexistující jméno
        Svatky svatky = new Svatky();
        assertTrue(svatky.jeVSeznamu("Emil"));
        assertFalse(svatky.jeVSeznamu("Fedor"));
    }

    /**
     * Testuje metodu {@link Svatky#getPocetJmen()}
     */
    @Test
    void getPocetJmen() {
        //testuje, že vrací počet jmen, která máme v seznamu
        Svatky svatky = new Svatky();
        assertEquals(svatky.getPocetJmen(), svatky.getSeznamJmen().size());
    }

    /**
     * Testuje metodu {@link Svatky#getSeznamJmen()}
     */
    @Test
    void getSeznamJmen() {
        //kontroluje, že seznam jmen má správný počet položek.
        Svatky svatky = new Svatky();
        assertEquals(svatky.getSeznamJmen().size(), svatky.getPocetJmen());
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, int)}
     */
    @Test
    void pridatSvatekDenMesicInt() {
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Marika",31,1);
        assertEquals(svatky.vratKdyMaSvatek("Marika"), MonthDay.of(1,31));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, int, Month)}
     */
    @Test
    void pridatSvatekDenMesicMonth() {
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Kamil",3,Month.MARCH);
        assertEquals(svatky.vratKdyMaSvatek("Kamil"), MonthDay.of(3,3));
    }

    /**
     * Testuje metodu {@link Svatky#pridejSvatek(String, MonthDay)}
     */
    @Test
    void prridatSvatekMonthDay() {
        //Otestuje, že je jméno v seznamu svátků a že má přiřazen správný den
        Svatky svatky = new Svatky();
        svatky.pridejSvatek("Alice",MonthDay.of(1,15));
        assertEquals(svatky.vratKdyMaSvatek("Alice"), MonthDay.of(1,15));
    }

    /**
     * Testuje metodu {@link Svatky#smazSvatek(String)}
     */
    @Test
    void smazatSvatek() {
        //Zkontroluje, že po smazání bude počet svátků odpovídat novému počtu.
        Svatky svatky = new Svatky();
        int pocetJmenPotom = svatky.getPocetJmen() - 1;

        svatky.smazSvatek("Claudia");
        assertEquals(pocetJmenPotom, svatky.getPocetJmen());
    }
}
