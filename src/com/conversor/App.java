package com.conversor;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
    JButton aceptarButton;
    JTextArea ingreseAquíElValorTextArea;
    JFormattedTextField campoValor;
    JPanel MainPanel;
    JComboBox<String> moneda1;
    JComboBox<String> moneda2;
    private JLabel texto1;
    private JLabel texto2;
    private JLabel resultado;
    private JLabel txmoneda1;
    private JLabel txmoneda2;
    private JLabel txpais2;
    private JLabel txpais1;
    private JLabel txtasa;
    private JButton guardarButton;

    static double valor;
    static double tasa;
    static double cambio;
    static Object de;
    static Object a;

    DecimalFormat df = new DecimalFormat("#,###.00");
    String consultas = "";

    String monedas = "[{\"CurrencyCode\":\"AED\",\"CurrencyName\":\"UAEDirham\",\"Country\":\"UnitedArabEmirates\"},{\"CurrencyCode\":\"AFN\",\"CurrencyName\":\"AfghanAfghani\",\"Country\":\"Afghanistan\"},{\"CurrencyCode\":\"ALL\",\"CurrencyName\":\"AlbanianLek\",\"Country\":\"Albania\"},{\"CurrencyCode\":\"AMD\",\"CurrencyName\":\"ArmenianDram\",\"Country\":\"Armenia\"},{\"CurrencyCode\":\"ANG\",\"CurrencyName\":\"NetherlandsAntillianGuilder\",\"Country\":\"NetherlandsAntilles\"},{\"CurrencyCode\":\"AOA\",\"CurrencyName\":\"AngolanKwanza\",\"Country\":\"Angola\"},{\"CurrencyCode\":\"ARS\",\"CurrencyName\":\"ArgentinePeso\",\"Country\":\"Argentina\"},{\"CurrencyCode\":\"AUD\",\"CurrencyName\":\"AustralianDollar\",\"Country\":\"Australia\"},{\"CurrencyCode\":\"AWG\",\"CurrencyName\":\"ArubanFlorin\",\"Country\":\"Aruba\"},{\"CurrencyCode\":\"AZN\",\"CurrencyName\":\"AzerbaijaniManat\",\"Country\":\"Azerbaijan\"},{\"CurrencyCode\":\"BAM\",\"CurrencyName\":\"BosniaandHerzegovinaMark\",\"Country\":\"BosniaandHerzegovina\"},{\"CurrencyCode\":\"BBD\",\"CurrencyName\":\"BarbadosDollar\",\"Country\":\"Barbados\"},{\"CurrencyCode\":\"BDT\",\"CurrencyName\":\"BangladeshiTaka\",\"Country\":\"Bangladesh\"},{\"CurrencyCode\":\"BGN\",\"CurrencyName\":\"BulgarianLev\",\"Country\":\"Bulgaria\"},{\"CurrencyCode\":\"BHD\",\"CurrencyName\":\"BahrainiDinar\",\"Country\":\"Bahrain\"},{\"CurrencyCode\":\"BIF\",\"CurrencyName\":\"BurundianFranc\",\"Country\":\"Burundi\"},{\"CurrencyCode\":\"BMD\",\"CurrencyName\":\"BermudianDollar\",\"Country\":\"Bermuda\"},{\"CurrencyCode\":\"BND\",\"CurrencyName\":\"BruneiDollar\",\"Country\":\"Brunei\"},{\"CurrencyCode\":\"BOB\",\"CurrencyName\":\"BolivianBoliviano\",\"Country\":\"Bolivia\"},{\"CurrencyCode\":\"BRL\",\"CurrencyName\":\"BrazilianReal\",\"Country\":\"Brazil\"},{\"CurrencyCode\":\"BSD\",\"CurrencyName\":\"BahamianDollar\",\"Country\":\"Bahamas\"},{\"CurrencyCode\":\"BTN\",\"CurrencyName\":\"BhutaneseNgultrum\",\"Country\":\"Bhutan\"},{\"CurrencyCode\":\"BWP\",\"CurrencyName\":\"BotswanaPula\",\"Country\":\"Botswana\"},{\"CurrencyCode\":\"BYN\",\"CurrencyName\":\"BelarusianRuble\",\"Country\":\"Belarus\"},{\"CurrencyCode\":\"BZD\",\"CurrencyName\":\"BelizeDollar\",\"Country\":\"Belize\"},{\"CurrencyCode\":\"CAD\",\"CurrencyName\":\"CanadianDollar\",\"Country\":\"Canada\"},{\"CurrencyCode\":\"CDF\",\"CurrencyName\":\"CongoleseFranc\",\"Country\":\"DemocraticRepublicoftheCongo\"},{\"CurrencyCode\":\"CHF\",\"CurrencyName\":\"SwissFranc\",\"Country\":\"Switzerland\"},{\"CurrencyCode\":\"CLP\",\"CurrencyName\":\"ChileanPeso\",\"Country\":\"Chile\"},{\"CurrencyCode\":\"CNY\",\"CurrencyName\":\"ChineseRenminbi\",\"Country\":\"China\"},{\"CurrencyCode\":\"COP\",\"CurrencyName\":\"ColombianPeso\",\"Country\":\"Colombia\"},{\"CurrencyCode\":\"CRC\",\"CurrencyName\":\"CostaRicanColon\",\"Country\":\"CostaRica\"},{\"CurrencyCode\":\"CUP\",\"CurrencyName\":\"CubanPeso\",\"Country\":\"Cuba\"},{\"CurrencyCode\":\"CVE\",\"CurrencyName\":\"CapeVerdeanEscudo\",\"Country\":\"CapeVerde\"},{\"CurrencyCode\":\"CZK\",\"CurrencyName\":\"CzechKoruna\",\"Country\":\"CzechRepublic\"},{\"CurrencyCode\":\"DJF\",\"CurrencyName\":\"DjiboutianFranc\",\"Country\":\"Djibouti\"},{\"CurrencyCode\":\"DKK\",\"CurrencyName\":\"DanishKrone\",\"Country\":\"Denmark\"},{\"CurrencyCode\":\"DOP\",\"CurrencyName\":\"DominicanPeso\",\"Country\":\"DominicanRepublic\"},{\"CurrencyCode\":\"DZD\",\"CurrencyName\":\"AlgerianDinar\",\"Country\":\"Algeria\"},{\"CurrencyCode\":\"EGP\",\"CurrencyName\":\"EgyptianPound\",\"Country\":\"Egypt\"},{\"CurrencyCode\":\"ERN\",\"CurrencyName\":\"EritreanNakfa\",\"Country\":\"Eritrea\"},{\"CurrencyCode\":\"ETB\",\"CurrencyName\":\"EthiopianBirr\",\"Country\":\"Ethiopia\"},{\"CurrencyCode\":\"EUR\",\"CurrencyName\":\"Euro\",\"Country\":\"EuropeanUnion\"},{\"CurrencyCode\":\"FJD\",\"CurrencyName\":\"FijiDollar\",\"Country\":\"Fiji\"},{\"CurrencyCode\":\"FKP\",\"CurrencyName\":\"FalklandIslandsPound\",\"Country\":\"FalklandIslands\"},{\"CurrencyCode\":\"FOK\",\"CurrencyName\":\"FaroeseKróna\",\"Country\":\"FaroeIslands\"},{\"CurrencyCode\":\"GBP\",\"CurrencyName\":\"PoundSterling\",\"Country\":\"UnitedKingdom\"},{\"CurrencyCode\":\"GEL\",\"CurrencyName\":\"GeorgianLari\",\"Country\":\"Georgia\"},{\"CurrencyCode\":\"GGP\",\"CurrencyName\":\"GuernseyPound\",\"Country\":\"Guernsey\"},{\"CurrencyCode\":\"GHS\",\"CurrencyName\":\"GhanaianCedi\",\"Country\":\"Ghana\"},{\"CurrencyCode\":\"GIP\",\"CurrencyName\":\"GibraltarPound\",\"Country\":\"Gibraltar\"},{\"CurrencyCode\":\"GMD\",\"CurrencyName\":\"GambianDalasi\",\"Country\":\"TheGambia\"},{\"CurrencyCode\":\"GNF\",\"CurrencyName\":\"GuineanFranc\",\"Country\":\"Guinea\"},{\"CurrencyCode\":\"GTQ\",\"CurrencyName\":\"GuatemalanQuetzal\",\"Country\":\"Guatemala\"},{\"CurrencyCode\":\"GYD\",\"CurrencyName\":\"GuyaneseDollar\",\"Country\":\"Guyana\"},{\"CurrencyCode\":\"HKD\",\"CurrencyName\":\"HongKongDollar\",\"Country\":\"HongKong\"},{\"CurrencyCode\":\"HNL\",\"CurrencyName\":\"HonduranLempira\",\"Country\":\"Honduras\"},{\"CurrencyCode\":\"HRK\",\"CurrencyName\":\"CroatianKuna\",\"Country\":\"Croatia\"},{\"CurrencyCode\":\"HTG\",\"CurrencyName\":\"HaitianGourde\",\"Country\":\"Haiti\"},{\"CurrencyCode\":\"HUF\",\"CurrencyName\":\"HungarianForint\",\"Country\":\"Hungary\"},{\"CurrencyCode\":\"IDR\",\"CurrencyName\":\"IndonesianRupiah\",\"Country\":\"Indonesia\"},{\"CurrencyCode\":\"ILS\",\"CurrencyName\":\"IsraeliNewShekel\",\"Country\":\"Israel\"},{\"CurrencyCode\":\"IMP\",\"CurrencyName\":\"ManxPound\",\"Country\":\"IsleofMan\"},{\"CurrencyCode\":\"INR\",\"CurrencyName\":\"IndianRupee\",\"Country\":\"India\"},{\"CurrencyCode\":\"IQD\",\"CurrencyName\":\"IraqiDinar\",\"Country\":\"Iraq\"},{\"CurrencyCode\":\"IRR\",\"CurrencyName\":\"IranianRial\",\"Country\":\"Iran\"},{\"CurrencyCode\":\"ISK\",\"CurrencyName\":\"IcelandicKróna\",\"Country\":\"Iceland\"},{\"CurrencyCode\":\"JEP\",\"CurrencyName\":\"JerseyPound\",\"Country\":\"Jersey\"},{\"CurrencyCode\":\"JMD\",\"CurrencyName\":\"JamaicanDollar\",\"Country\":\"Jamaica\"},{\"CurrencyCode\":\"JOD\",\"CurrencyName\":\"JordanianDinar\",\"Country\":\"Jordan\"},{\"CurrencyCode\":\"JPY\",\"CurrencyName\":\"JapaneseYen\",\"Country\":\"Japan\"},{\"CurrencyCode\":\"KES\",\"CurrencyName\":\"KenyanShilling\",\"Country\":\"Kenya\"},{\"CurrencyCode\":\"KGS\",\"CurrencyName\":\"KyrgyzstaniSom\",\"Country\":\"Kyrgyzstan\"},{\"CurrencyCode\":\"KHR\",\"CurrencyName\":\"CambodianRiel\",\"Country\":\"Cambodia\"},{\"CurrencyCode\":\"KID\",\"CurrencyName\":\"KiribatiDollar\",\"Country\":\"Kiribati\"},{\"CurrencyCode\":\"KMF\",\"CurrencyName\":\"ComorianFranc\",\"Country\":\"Comoros\"},{\"CurrencyCode\":\"KRW\",\"CurrencyName\":\"SouthKoreanWon\",\"Country\":\"SouthKorea\"},{\"CurrencyCode\":\"KWD\",\"CurrencyName\":\"KuwaitiDinar\",\"Country\":\"Kuwait\"},{\"CurrencyCode\":\"KYD\",\"CurrencyName\":\"CaymanIslandsDollar\",\"Country\":\"CaymanIslands\"},{\"CurrencyCode\":\"KZT\",\"CurrencyName\":\"KazakhstaniTenge\",\"Country\":\"Kazakhstan\"},{\"CurrencyCode\":\"LAK\",\"CurrencyName\":\"LaoKip\",\"Country\":\"Laos\"},{\"CurrencyCode\":\"LBP\",\"CurrencyName\":\"LebanesePound\",\"Country\":\"Lebanon\"},{\"CurrencyCode\":\"LKR\",\"CurrencyName\":\"SriLankaRupee\",\"Country\":\"SriLanka\"},{\"CurrencyCode\":\"LRD\",\"CurrencyName\":\"LiberianDollar\",\"Country\":\"Liberia\"},{\"CurrencyCode\":\"LSL\",\"CurrencyName\":\"LesothoLoti\",\"Country\":\"Lesotho\"},{\"CurrencyCode\":\"LYD\",\"CurrencyName\":\"LibyanDinar\",\"Country\":\"Libya\"},{\"CurrencyCode\":\"MAD\",\"CurrencyName\":\"MoroccanDirham\",\"Country\":\"Morocco\"},{\"CurrencyCode\":\"MDL\",\"CurrencyName\":\"MoldovanLeu\",\"Country\":\"Moldova\"},{\"CurrencyCode\":\"MGA\",\"CurrencyName\":\"MalagasyAriary\",\"Country\":\"Madagascar\"},{\"CurrencyCode\":\"MKD\",\"CurrencyName\":\"MacedonianDenar\",\"Country\":\"NorthMacedonia\"},{\"CurrencyCode\":\"MMK\",\"CurrencyName\":\"BurmeseKyat\",\"Country\":\"Myanmar\"},{\"CurrencyCode\":\"MNT\",\"CurrencyName\":\"MongolianTögrög\",\"Country\":\"Mongolia\"},{\"CurrencyCode\":\"MOP\",\"CurrencyName\":\"MacanesePataca\",\"Country\":\"Macau\"},{\"CurrencyCode\":\"MRU\",\"CurrencyName\":\"MauritanianOuguiya\",\"Country\":\"Mauritania\"},{\"CurrencyCode\":\"MUR\",\"CurrencyName\":\"MauritianRupee\",\"Country\":\"Mauritius\"},{\"CurrencyCode\":\"MVR\",\"CurrencyName\":\"MaldivianRufiyaa\",\"Country\":\"Maldives\"},{\"CurrencyCode\":\"MWK\",\"CurrencyName\":\"MalawianKwacha\",\"Country\":\"Malawi\"},{\"CurrencyCode\":\"MXN\",\"CurrencyName\":\"MexicanPeso\",\"Country\":\"Mexico\"},{\"CurrencyCode\":\"MYR\",\"CurrencyName\":\"MalaysianRinggit\",\"Country\":\"Malaysia\"},{\"CurrencyCode\":\"MZN\",\"CurrencyName\":\"MozambicanMetical\",\"Country\":\"Mozambique\"},{\"CurrencyCode\":\"NAD\",\"CurrencyName\":\"NamibianDollar\",\"Country\":\"Namibia\"},{\"CurrencyCode\":\"NGN\",\"CurrencyName\":\"NigerianNaira\",\"Country\":\"Nigeria\"},{\"CurrencyCode\":\"NIO\",\"CurrencyName\":\"NicaraguanCórdoba\",\"Country\":\"Nicaragua\"},{\"CurrencyCode\":\"NOK\",\"CurrencyName\":\"NorwegianKrone\",\"Country\":\"Norway\"},{\"CurrencyCode\":\"NPR\",\"CurrencyName\":\"NepaleseRupee\",\"Country\":\"Nepal\"},{\"CurrencyCode\":\"NZD\",\"CurrencyName\":\"NewZealandDollar\",\"Country\":\"NewZealand\"},{\"CurrencyCode\":\"OMR\",\"CurrencyName\":\"OmaniRial\",\"Country\":\"Oman\"},{\"CurrencyCode\":\"PAB\",\"CurrencyName\":\"PanamanianBalboa\",\"Country\":\"Panama\"},{\"CurrencyCode\":\"PEN\",\"CurrencyName\":\"PeruvianSol\",\"Country\":\"Peru\"},{\"CurrencyCode\":\"PGK\",\"CurrencyName\":\"PapuaNewGuineanKina\",\"Country\":\"PapuaNewGuinea\"},{\"CurrencyCode\":\"PHP\",\"CurrencyName\":\"PhilippinePeso\",\"Country\":\"Philippines\"},{\"CurrencyCode\":\"PKR\",\"CurrencyName\":\"PakistaniRupee\",\"Country\":\"Pakistan\"},{\"CurrencyCode\":\"PLN\",\"CurrencyName\":\"PolishZłoty\",\"Country\":\"Poland\"},{\"CurrencyCode\":\"PYG\",\"CurrencyName\":\"ParaguayanGuaraní\",\"Country\":\"Paraguay\"},{\"CurrencyCode\":\"QAR\",\"CurrencyName\":\"QatariRiyal\",\"Country\":\"Qatar\"},{\"CurrencyCode\":\"RON\",\"CurrencyName\":\"RomanianLeu\",\"Country\":\"Romania\"},{\"CurrencyCode\":\"RSD\",\"CurrencyName\":\"SerbianDinar\",\"Country\":\"Serbia\"},{\"CurrencyCode\":\"RUB\",\"CurrencyName\":\"RussianRuble\",\"Country\":\"Russia\"},{\"CurrencyCode\":\"RWF\",\"CurrencyName\":\"RwandanFranc\",\"Country\":\"Rwanda\"},{\"CurrencyCode\":\"SAR\",\"CurrencyName\":\"SaudiRiyal\",\"Country\":\"SaudiArabia\"},{\"CurrencyCode\":\"SBD\",\"CurrencyName\":\"SolomonIslandsDollar\",\"Country\":\"SolomonIslands\"},{\"CurrencyCode\":\"SCR\",\"CurrencyName\":\"SeychelloisRupee\",\"Country\":\"Seychelles\"},{\"CurrencyCode\":\"SDG\",\"CurrencyName\":\"SudanesePound\",\"Country\":\"Sudan\"},{\"CurrencyCode\":\"SEK\",\"CurrencyName\":\"SwedishKrona\",\"Country\":\"Sweden\"},{\"CurrencyCode\":\"SGD\",\"CurrencyName\":\"SingaporeDollar\",\"Country\":\"Singapore\"},{\"CurrencyCode\":\"SHP\",\"CurrencyName\":\"SaintHelenaPound\",\"Country\":\"SaintHelena\"},{\"CurrencyCode\":\"SLE\",\"CurrencyName\":\"SierraLeoneanLeone\",\"Country\":\"SierraLeone\"},{\"CurrencyCode\":\"SOS\",\"CurrencyName\":\"SomaliShilling\",\"Country\":\"Somalia\"},{\"CurrencyCode\":\"SRD\",\"CurrencyName\":\"SurinameseDollar\",\"Country\":\"Suriname\"},{\"CurrencyCode\":\"SSP\",\"CurrencyName\":\"SouthSudanesePound\",\"Country\":\"SouthSudan\"},{\"CurrencyCode\":\"STN\",\"CurrencyName\":\"SãoToméandPríncipeDobra\",\"Country\":\"SãoToméandPríncipe\"},{\"CurrencyCode\":\"SYP\",\"CurrencyName\":\"SyrianPound\",\"Country\":\"Syria\"},{\"CurrencyCode\":\"SZL\",\"CurrencyName\":\"EswatiniLilangeni\",\"Country\":\"Eswatini\"},{\"CurrencyCode\":\"THB\",\"CurrencyName\":\"ThaiBaht\",\"Country\":\"Thailand\"},{\"CurrencyCode\":\"TJS\",\"CurrencyName\":\"TajikistaniSomoni\",\"Country\":\"Tajikistan\"},{\"CurrencyCode\":\"TMT\",\"CurrencyName\":\"TurkmenistanManat\",\"Country\":\"Turkmenistan\"},{\"CurrencyCode\":\"TND\",\"CurrencyName\":\"TunisianDinar\",\"Country\":\"Tunisia\"},{\"CurrencyCode\":\"TOP\",\"CurrencyName\":\"TonganPaʻanga\",\"Country\":\"Tonga\"},{\"CurrencyCode\":\"TRY\",\"CurrencyName\":\"TurkishLira\",\"Country\":\"Turkey\"},{\"CurrencyCode\":\"TTD\",\"CurrencyName\":\"TrinidadandTobagoDollar\",\"Country\":\"TrinidadandTobago\"},{\"CurrencyCode\":\"TVD\",\"CurrencyName\":\"TuvaluanDollar\",\"Country\":\"Tuvalu\"},{\"CurrencyCode\":\"TWD\",\"CurrencyName\":\"NewTaiwanDollar\",\"Country\":\"Taiwan\"},{\"CurrencyCode\":\"TZS\",\"CurrencyName\":\"TanzanianShilling\",\"Country\":\"Tanzania\"},{\"CurrencyCode\":\"UAH\",\"CurrencyName\":\"UkrainianHryvnia\",\"Country\":\"Ukraine\"},{\"CurrencyCode\":\"UGX\",\"CurrencyName\":\"UgandanShilling\",\"Country\":\"Uganda\"},{\"CurrencyCode\":\"USD\",\"CurrencyName\":\"UnitedStatesDollar\",\"Country\":\"UnitedStates\"},{\"CurrencyCode\":\"UYU\",\"CurrencyName\":\"UruguayanPeso\",\"Country\":\"Uruguay\"},{\"CurrencyCode\":\"UZS\",\"CurrencyName\":\"UzbekistaniSo'm\",\"Country\":\"Uzbekistan\"},{\"CurrencyCode\":\"VES\",\"CurrencyName\":\"VenezuelanBolívarSoberano\",\"Country\":\"Venezuela\"},{\"CurrencyCode\":\"VND\",\"CurrencyName\":\"VietnameseĐồng\",\"Country\":\"Vietnam\"},{\"CurrencyCode\":\"VUV\",\"CurrencyName\":\"VanuatuVatu\",\"Country\":\"Vanuatu\"},{\"CurrencyCode\":\"WST\",\"CurrencyName\":\"SamoanTālā\",\"Country\":\"Samoa\"},{\"CurrencyCode\":\"XAF\",\"CurrencyName\":\"CentralAfricanCFAFranc\",\"Country\":\"CEMAC\"},{\"CurrencyCode\":\"XCD\",\"CurrencyName\":\"EastCaribbeanDollar\",\"Country\":\"OrganisationofEasternCaribbeanStates\"},{\"CurrencyCode\":\"XDR\",\"CurrencyName\":\"SpecialDrawingRights\",\"Country\":\"InternationalMonetaryFund\"},{\"CurrencyCode\":\"XOF\",\"CurrencyName\":\"WestAfricanCFAfranc\",\"Country\":\"CFA\"},{\"CurrencyCode\":\"XPF\",\"CurrencyName\":\"CFPFranc\",\"Country\":\"Collectivitésd'Outre-Mer\"},{\"CurrencyCode\":\"YER\",\"CurrencyName\":\"YemeniRial\",\"Country\":\"Yemen\"},{\"CurrencyCode\":\"ZAR\",\"CurrencyName\":\"SouthAfricanRand\",\"Country\":\"SouthAfrica\"},{\"CurrencyCode\":\"ZMW\",\"CurrencyName\":\"ZambianKwacha\",\"Country\":\"Zambia\"},{\"CurrencyCode\":\"ZWL\",\"CurrencyName\":\"ZimbabweanDollar\",\"Country\":\"Zimbabwe\"}]";

    Gson gson = new Gson();
    java.lang.reflect.Type listType = new TypeToken<List<Moneda>>(){}.getType();
    List<Moneda> listaMonedas = gson.fromJson(monedas, listType);

    // Crear un PlainDocument para limitar la entrada de texto a números
    PlainDocument doc = new PlainDocument() {
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

            if (str == null) {
                return;
            }

            // Verificar si la cadena solo contiene dígitos
            for (int i = 0; i < str.length(); i++) {
                final boolean isDecimalPoint = str.charAt(i) == '.';
                if (!isDecimalPoint && !Character.isDigit(str.charAt(i))) {
                    return; // Ignorar la inserción si no es un dígito
                }
            }

            // Insertar la cadena solo si todos los caracteres son dígitos
            super.insertString(offs, str, a);
        }
    };

    public static void main(String[] args) throws ParseException {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().MainPanel);
        frame.setTitle("Conversor de Monedas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


    public void llenarComboBox() {
        for (Moneda moneda : listaMonedas) {
            moneda1.addItem(moneda.CurrencyCode());
            moneda2.addItem(moneda.CurrencyCode());
        }
    }

    public Moneda buscarMoneda(String codMoneda){
        Moneda resultado = null;
        for (Moneda moneda : listaMonedas){
            if (moneda.CurrencyCode().equals(codMoneda)){
                resultado = moneda;
                break;
            }
        }
        return resultado;
    }

    public App() {
        campoValor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                campoValor.setDocument(doc);
                llenarComboBox();
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valor = Double.parseDouble(campoValor.getText());
                Conversor conversor = new Conversor();
                de = moneda1.getSelectedItem();
                a = moneda2.getSelectedItem();
                tasa = conversor.obtenerTasa(de, a);
                cambio = conversor.calcularCambio(valor);
                resultado.setText(df.format(cambio) + " " + a);
                txmoneda1.setText(buscarMoneda(de.toString()).CurrencyName());
                txpais1.setText(buscarMoneda(de.toString()).Country());
                txmoneda2.setText(buscarMoneda(a.toString()).CurrencyName());
                txpais2.setText(buscarMoneda(a.toString()).Country());
                txtasa.setText("1 "+ de + "= " + df.format(tasa) +" " + a);
                guardarButton.setEnabled(true);
            }
        });

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String registro = "_______________________________________________\n" +
                        LocalDate.now() + " " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) +
                        "\nTasa: 1 " + de + " = " + tasa + " " + a +
                        "\nConsulta: " + df.format(Double.valueOf(campoValor.getText())) +" " + de + " = " + df.format(cambio) + " " + a +"\n";
                consultas += registro;
                JOptionPane.showMessageDialog(guardarButton,consultas);
                guardarButton.setEnabled(false);
            }
        });

    }

}
