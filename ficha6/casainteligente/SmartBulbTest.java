package casainteligente;

/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SmartBulbTest.
 *
 * @author  Simão Cunha
 * @version 2021/04/14
 */
public class SmartBulbTest extends SmartDeviceTest {
    public static final int WARM    = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD    = 0;

    private int tone;
    /**
     * Default constructor for test class SmartBulbTest
     */
    public SmartBulbTest (){
        super ();
        this.tone = NEUTRAL;
    }

    public SmartBulbTest (String id, int tone){
        super(id);
        this.tone = tone;
    }

    public SmartBulbTest(String id){
        super(id);
        this.tone = NEUTRAL;
    }

    public SmartBulbTest (SmartBulbTest sbt){
        super();
        this.tone = sbt.getTone();
    }

    public int getTone() {
        return tone;
    }

    public void setTone(int t){
        this.tone = t;
    }

    public SmartBulbTest clone() {
        return new SmartBulbTest(this);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("SmartBulbTest {\n");
        sb.append(super.toString());
        sb.append("Tonalidade = ").append(tone).append('\n');
        sb.append("}");
        return sb.toString();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp(){
        this.tone = WARM; // corrigir
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown(){
        this.tone = COLD; // corrigir
    }

    @Test
    public void testContructor() {
        SmartBulb smartBul1 = new SmartBulb();
        assertTrue(smartBul1!=null);
        smartBul1 = new SmartBulb("b1");
        assertTrue(smartBul1!=null);
        smartBul1 = new SmartBulb("b1", SmartBulb.NEUTRAL);
        assertTrue(smartBul1!=null);
    }



    @Test
    public void testGetTone() {
        SmartBulb smartBul1 = new SmartBulb("b1", 0);
        assertEquals(0, smartBul1.getTone());
        smartBul1 = new SmartBulb("b1", 1);
        assertEquals(1, smartBul1.getTone());
        smartBul1 = new SmartBulb("b1", 2);
        assertEquals(2, smartBul1.getTone());
        smartBul1 = new SmartBulb("b1");
        assertEquals(SmartBulb.NEUTRAL, smartBul1.getTone());
    }

    @Test
    public void testSetTone() {
        SmartBulb smartBul1 = new SmartBulb("b1");
        smartBul1.setTone(2);
        assertEquals(2, smartBul1.getTone());
        smartBul1.setTone(10);
        assertEquals(2, smartBul1.getTone());
        smartBul1.setTone(-10);
        assertEquals(0, smartBul1.getTone());
    }

}



