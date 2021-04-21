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
 * The test class SmartDeviceTest.
 *
 * @author  Simão Cunha
 * @version 2021/04/14
 */
public class SmartDeviceTest extends CasaInteligenteTest {
    private String divisao;
    private String id;
    private boolean on;

    /**
     * Default constructor for test class SmartDeviceTest
     */
    public SmartDeviceTest(){
        this.divisao = "";
        this.id = "";
        this.on = false;
    }


    public SmartDeviceTest (String d, String id, boolean on){
        this.divisao = d;
        this.id = id;
        this.on = on;
    }

    public SmartDeviceTest (String s){
        this.divisao = s;
        this.id = "";
        this.on = false;
    }


    public SmartDeviceTest (SmartDeviceTest sdt){
        this.divisao = sdt.getDivisao();
        this.id = sdt.getID();
        this.on = sdt.getOn();
    }

    public int getDivisao() {
        return divisao;
    }

    public void setDivisao(String d){
        this.divisao = d;
    }

    public int getID() {
        return id;
    }

    public void setID(String id){
        this.id = id;
    }

    public boolean getOn() {
        return true;
    }

    public void setOn(boolean o){
        this.on = o;
    }

    public SmartDeviceTest clone() {
        return new SmartDeviceTest(this);
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("SmartDeviceTest {\n");
        sb.append(super.toString());
        sb.append("Localização do SmartDeviceTest = ").append(divisao).append('\n');      
        sb.append("Nome do SmartDeviceTest = ").append(id).append('\n');
        if (on)
            sb.append("Modo de funcionamento: Ligado\n");
        else
            sb.append("Modo de funcionamento: Desligado\n");            
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
        this.id = id; //corrigir
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown(){
        this.on = on; //corrigir
    }
    
        @Test
    public void testContructor() {
        SmartDevice smartDev1 = new SmartDevice();
        assertTrue(smartDev1!=null);
        smartDev1 = new SmartDevice("b1");
        assertTrue(smartDev1!=null);
        smartDev1 = new SmartDevice("b1", true);
        assertTrue(smartDev1!=null);
    }
    
    @Test
    public void testGetID() {
        SmartDevice smartDev1 = new SmartDevice();
        assertEquals("", smartDev1.getID());
        smartDev1 = new SmartDevice("b1");
        assertEquals("b1", smartDev1.getID());
    }
    
    @Test
    public void testGetOn() {
        SmartDevice smartDev1 = new SmartDevice();
        assertFalse(smartDev1.getOn());
        smartDev1 = new SmartDevice("b1", false);
        assertFalse(smartDev1.getOn());
        smartDev1 = new SmartDevice("b1", true);
        assertTrue(smartDev1.getOn());
    }

    @Test
    public void testSetOn() {
        SmartDevice smartDev1 = new SmartDevice("b1", false);
        smartDev1.setOn(true);
        assertTrue(smartDev1.getOn());
        smartDev1.setOn(false);
        assertFalse(smartDev1.getOn());
    }
}
