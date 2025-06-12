/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.DepartamentsDAO;
import dao.EmpleatsDAO;
import dto.Departament;
import dto.Empleat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.toMap;
import java.util.stream.Stream;

/**
 *
 * @author jmas, David García Valero
 */
public class Main {

    // Hay varios que no he podido hacer, si es posible, querría saber la explicación de ellos (para tenerlos más claros de cara al examen), ¡gracias!
    
    public static void main(String[] args) {
        // 1.- Imprimeix el primer empleat trobat amb més de 50 anys
        Stream<Empleat> empleado0 = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getEdat() > 50)
                .limit(1);
        System.out.println(empleado0.toList());

        // 2. Imprimeix true si tots els empleats son majors d'edat i false en cas contrari
        Boolean empleadosMayoresEdad = EmpleatsDAO.getEmpleats().stream()
                .allMatch(a -> a.getEdat() >= 18);
        System.out.println(empleadosMayoresEdad);

        // 3. Imprimeix true si hi ha algun empleat major de 65 anys i false en cas contrari
        Boolean empleadosMayores65 = EmpleatsDAO.getEmpleats().stream()
                .anyMatch(a -> a.getEdat() > 65);
        System.out.println(empleadosMayores65);

        // 4. Imprimeix el número d'empleats que tenen més de 50 anys
        Long empleadoLong = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getEdat() > 50)
                .collect(counting());
        System.out.println(empleadoLong);

        // 5. Imprimeix el nom dels empleats del departament d'informàtica, en majúscules.
        String empleadosInformaticaNombres = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Informàtica"))
                .map(Empleat::getNom)
                .collect(Collectors.joining(", "));
        System.out.println(empleadosInformaticaNombres.toUpperCase());

        // 6. Imprimeix la quantitat de lletres de l'empleat d'informàtica amb el nom més llarg.
        String empleadoInformatica0 = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getNom)
                .max(Comparator.comparing(s -> s.length()))
                .get();
        System.out.println(empleadoInformatica0.length());     
        
        // 7. Imprimeix el nom dels departaments que comencen per C
        String departamentosC = DepartamentsDAO.getDepartaments().stream()
                .map(Departament::getNom)
                .filter(s -> s.startsWith("C"))
                .collect(Collectors.joining(", "));
        System.out.println(departamentosC);

        // 8. Imprimeix la suma de totes les edats dels empleats
        Integer empleadosSumaEdad = EmpleatsDAO.getEmpleats().stream()
                .mapToInt(Empleat::getEdat)
                .sum();
        System.out.println(empleadosSumaEdad);

        // 9 UTILITZA EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la quantitat d'empleats de cada departament // No consigo acceder al stream de Empleat y conseguir sus datos, siempre me quedo con la cantidad de departamentos

        // 10. UTILITZANT EL MÈTODE GETEMPLEATS DE LA CLASSE DEPARTAMENT (NOMÉS PER A L'EXERCICI 9 I 10)
        // Imprimeix la llista de noms dels empleats del departament comercial i de comptatilitat (una única llista d'String)
        List<ArrayList<Empleat>> nombreEmpleadosDepartamentosCC = DepartamentsDAO.getDepartaments().stream()
                .filter(a -> a.getNom().equals("Comercial") || a.getNom().equals("Comptabilitat"))
                .map(Departament::getEmpleats)
                .toList();
        System.out.println(nombreEmpleadosDepartamentosCC);
        
        // 11. El mateix d'abans però mostra els noms ordenats alfabèticament.

        // 12. Mostra la mitjana d'edat dels empleats del departament d'informàtica.
        Double mediaEdadInformatica = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Informàtica"))
                .mapToInt(Empleat::getEdat)
                .average()
                .getAsDouble();
        System.out.println(mediaEdadInformatica);

        // 13. Mostra un String que serà el resultat de concatenar la primera lletra de cada departament.
        String departamentosPrimeraLetra = DepartamentsDAO.getDepartaments().stream()
                .map(Departament::getNom)
                .collect(Collectors.joining(""));
        departamentosPrimeraLetra = String.valueOf(departamentosPrimeraLetra.charAt(0)) + String.valueOf(departamentosPrimeraLetra.charAt(4)) + String.valueOf(departamentosPrimeraLetra.charAt(13)) + String.valueOf(departamentosPrimeraLetra.charAt(26)) + String.valueOf(departamentosPrimeraLetra.charAt(37));
        System.out.println(departamentosPrimeraLetra);
                
        // 14. Mostra el número de telèfon més alt dels departaments.
        Integer telfMesAlt = DepartamentsDAO.getDepartaments().stream()
                .map(Departament::getTelefon)
                .max(Comparator.naturalOrder())
                .get();
        System.out.println(telfMesAlt);

        // 15. Mostra el departament complet amb el número de telèfon més alt.
        Optional<Departament> numTelfAlt = DepartamentsDAO.getDepartaments().stream()
                .max(Comparator.comparing(s -> s.getTelefon()));
        System.out.println(numTelfAlt);  

        // 16. Sense fer ús del mètode "getEmpleats". Dels departament que tenen treballadors, mostrar el nom del departament i el nombre de treballadors que hi treballen.
        System.out.println("--CANTIDAD DE EMPLEADOS POR DEPARTAMENTO");
        
        Long cantidadEmpleadosInformatica1 = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Informàtica"))
                .count();
        System.out.println(cantidadEmpleadosInformatica1);
        
        Long cantidadEmpleadosRRHH1 = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("RRHH"))
                .count();
        System.out.println(cantidadEmpleadosRRHH1);
        
        Long cantidadEmpleadosComercial1 = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comercial"))
                .count();
        System.out.println(cantidadEmpleadosComercial1);
        
        Long cantidadEmpleadosComptabilitat1 = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comptabilitat"))
                .count();
        System.out.println(cantidadEmpleadosComptabilitat1);
        
        Long cantidadEmpleadosProducció1 = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Producció"))
                .count();
        System.out.println(cantidadEmpleadosProducció1);
                
        System.out.println("CANTIDAD DE EMPLEADOS POR DEPARTAMENTO--");

        // 17A. Guarda en un Map un registre per a cada Departament (que tinga treballadors) que tinga associat com a valor la llista d'empleats d'eixe departament
        Stream<ArrayList<Empleat>> listaEmpleadosRRHH = DepartamentsDAO.getDepartaments().stream()
                .filter(a -> a.getNom().equals("RRHH"))
                .map(Departament::getEmpleats);
        Stream<ArrayList<Empleat>> listaEmpleadosComercial = DepartamentsDAO.getDepartaments().stream()
                .filter(a -> a.getNom().equals("Comercial"))
                .map(Departament::getEmpleats);
        Stream<ArrayList<Empleat>> listaEmpleadosComptabilitat = DepartamentsDAO.getDepartaments().stream()
                .filter(a -> a.getNom().equals("Comptabilitat"))
                .map(Departament::getEmpleats);
        Stream<ArrayList<Empleat>> listaEmpleadosInformàtica = DepartamentsDAO.getDepartaments().stream()
                .filter(a -> a.getNom().equals("Informàtica"))
                .map(Departament::getEmpleats);
        Stream<ArrayList<Empleat>> listaEmpleadosProducció = DepartamentsDAO.getDepartaments().stream()
                .filter(a -> a.getNom().equals("Producció"))
                .map(Departament::getEmpleats);
        
        // 17B. Igual que l'anterior pero la llista no serà d'empleats sino del nom dels empleats
        Stream<String> listaNomEmpleatsRRHH = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("RRHH"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom);
        Stream<String> listaNomEmpleatsComercial = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comercial"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom);
        Stream<String> listaNomEmpleatsComptabilitat = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comptabilitat"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom);
        Stream<String> listaNomEmpleatsInformàtica = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Informàtica"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom);
        Stream<String> listaNomEmpleatsProducció = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Producció"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom);

        // 17C. Igual que l'anterior pero amb els empleats ordenats alfabèticament
        Stream<String> listaNomEmpleatsRRHHS = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("RRHH"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom)
                .sorted(); // Aquí se puede hacer un .collect(Collectors.toList()), cambiando listaNomEmpleats a List<String>, para que aparezca la lista en vez del map.
        Stream<String> listaNomEmpleatsComercialS = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comercial"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom)
                .sorted();
        Stream<String> listaNomEmpleatsComptabilitatS = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comptabilitat"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom)
                .sorted();
        Stream<String> listaNomEmpleatsInformàticaS = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Informàtica"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom)
                .sorted();
        Stream<String> listaNomEmpleatsProduccióS = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Producció"))
                .filter(a -> a.getNom() != null)
                .map(Empleat::getNom)
                .sorted();
        
        // 18A. Obtín un Map que continga per a cada departament una llista d'enters grans (BigInteger) que es corresponguen amb les edats dels empleats d'eixe departament
        Stream<Integer> listaEdatEmpleatsProducció = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Producció"))
                .map(Empleat::getEdat); // No se como pasarlo a BigInteger
                
       
        // 18B. El mateix que abans però en comptes de l'edat, el probable següent número primer // No entiendo qué es "el probable següent número primer"

        // 19. Obtín un Map que continga per a cada departament l'empleat més jove.
        Optional<String> empleatMesJoveRRHH = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("RRHH"))
                .min(Comparator.comparing(s -> s.getEdat()))
                .map(Empleat::toString); // Sin hacer un map, el stream podría ser Empleat.
        Optional<String> empleatMesJoveComercial = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comercial"))
                .min(Comparator.comparing(s -> s.getEdat()))
                .map(Empleat::toString);
        Optional<String> empleatMesJoveComptabilitat = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Comptabilitat"))
                .min(Comparator.comparing(s -> s.getEdat()))
                .map(Empleat::toString);
        Optional<String> empleatMesJoveInformàtica = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Informàtica"))
                .min(Comparator.comparing(s -> s.getEdat()))
                .map(Empleat::toString);
        Optional<String> empleatMesJoveProducció = EmpleatsDAO.getEmpleats().stream()
                .filter(a -> a.getDepartament().getNom().equals("Producció"))
                .min(Comparator.comparing(s -> s.getEdat()))
                .map(Empleat::toString);
                 
        // 20. Obtín un String que continga el mateix que abans, amb el format "Departament1:Empleat1, Departament2:Empleat2 ..."

        // 21. Obtín un Map que conté com a clau el DNI dels empleats i com a valor el nom d'eixe empleat
        Map<String,String> dniNomEmpleats = EmpleatsDAO.getEmpleats().stream()
                .collect(toMap(p -> p.getDni(), p -> p.getNom()));

        // 21. Obtín una llista d'Strings que continga DNI dels empleats i el nom d'eixe empleat amb el format DNI - Nom. Llista ordenada per DNI

        // 22A. Donat un array bidimensional d'Integer transformar-lo en un array unidimensional amb els mateixos valors:
        Integer[][] matriuInteger = {{3, 2, 5}, {0, -8, 7}, {9, 9, 6}};
        Integer[] integerArray = new Integer[9];
        int a = 0;
        for (int i = 0; i < matriuInteger.length; i++) {
            for (int j = 0; j < matriuInteger.length; j++) {
                integerArray[a] = matriuInteger[i][j];
                a++;
            }  
        }

        // 22B. Versió amb int[] en comptes d'Integer[]
              
        // 23. Guarda una llista amb els noms dels estudis de tots els empleats (de forma única), ordenats alfabèticament.
        Stream<ArrayList<String>> nomsEstudis = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getTitols);
        System.out.println(nomsEstudis.toList());

        // 24. Imprimeix per pantalla aquells empleats que tinguen un CFGS
        List<Empleat> empleatsCFGS = EmpleatsDAO.getEmpleats().stream()
                .filter(e -> e.getTitols().contains("CFGS"))
                .collect(Collectors.toList());
        System.out.println(empleatsCFGS);

        // 25. Mostra un empleat qualsevol que tinga una llicenciatura
        List<Empleat> empleatLlicenciatura = EmpleatsDAO.getEmpleats().stream()
                .filter(e -> e.getTitols().contains("Llicenciatura"))
                .limit(1)
                .collect(Collectors.toList());
        System.out.println(empleatLlicenciatura);

        // 26. Mostra per a cada nom d'empleat la suma de les lletres dels seus titols

        // 27. Mostra el total de lletres dels titols (incloent duplicats) dels empleats
        Stream<ArrayList<String>> nomsEstudis1 = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getTitols);
        System.out.println(nomsEstudis1.toList().toString().length());
        
        // 28. Mostra l'empleat amb major quantitat de títols
         Optional<Empleat> empleatMesTitols = EmpleatsDAO.getEmpleats().stream()
                 .max(Comparator.comparing(s -> s.getTitols().size()));
         System.out.println(empleatMesTitols);

        // 29A. Obtín una llista que continga 5 aleatoris entre 0 i 9 en format String
        ArrayList<String> llistaAleatoris0 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            llistaAleatoris0.add((int) (Math.random()*10) + "");
        }

        // 29B. El mateix d'abans, però ara sense valors repetits.
        ArrayList<String> llistaAleatoris1 = new ArrayList<>();
        while (llistaAleatoris1.size() < 5) {
            int x = (int) (Math.random()*10);
            if (!llistaAleatoris1.contains(x + "")) {
                llistaAleatoris1.add(x + "");
            }
        }

        // 30. Crea un stream amb tots els números positius divisibles entre 3. Després filtra aquells que siguen quadrats perfectes. 
        // Després descarta els 5 primers valors obtinguts. Finalment mostra els 10 següents valors obtinguts

        // 31. A partir dels cognoms dels empleats imprimeix amb una operació intermèdia els cognoms sense transformar i després transformats en majúscules.
        // Finalment retorna el nombre d'empleats.
        String empleadosApellidos = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getCognoms)
                .collect(Collectors.joining(", "));
        System.out.println(empleadosApellidos);
        System.out.println(empleadosApellidos.toUpperCase());
        
        String empleadosNombres = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getNom)
                .collect(Collectors.joining(", "));
        System.out.println(empleadosNombres);

        // 32. Imprimeix el cognom dels empleats ordenats en ordre alfabètic invers.
        String empleadosApellidosAlfabeticInvers = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getCognoms)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
        System.out.println(empleadosApellidosAlfabeticInvers);

        // 33. Obtín la suma dels títols de tots els empleats

        // 34. Obtín un String amb la concatenació dels títols d'aquells empleats que tinguen menys de 30 anys, separats per espais (sense duplicats)
        Stream<ArrayList<String>> titulosEmpleadosMenos30anys = EmpleatsDAO.getEmpleats().stream()
                .filter(s -> s.getEdat() < 30)
                .map(Empleat::getTitols);
        System.out.println(titulosEmpleadosMenos30anys.toList().toString());

        // 35A. Mostra el cognom del primer dels empleats trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        // ¿I si proves per a menors de 40?
        String empleadoApellidoMenor30 = EmpleatsDAO.getEmpleats().stream()
                .filter(s -> s.getEdat() < 30 && s.getTitols().contains("Llicenciatura"))
                .limit(1)
                .map(Empleat::getCognoms)
                .collect(Collectors.collectingAndThen(Collectors.joining(", "), s -> s.isEmpty() ? "No trobat" : s));
        System.out.println(empleadoApellidoMenor30);
        
        String empleadoApellidoMenor40 = EmpleatsDAO.getEmpleats().stream()
                .filter(s -> s.getEdat() < 40 && s.getTitols().contains("Llicenciatura"))
                .limit(1)
                .map(Empleat::getCognoms)
                .collect(Collectors.collectingAndThen(Collectors.joining(", "), s -> s.isEmpty() ? "No trobat" : s));
        System.out.println(empleadoApellidoMenor40);

        // 35B. Mostra el primer dels empleats (complet) trobat que tinga menys de 30 anys i que tinga una llicenciatura. En cas de no trobar-lo mostra "No trobat"
        // ¿I si proves per a menors de 40?
        Object empleadoMenor30 = EmpleatsDAO.getEmpleats().stream()
                .filter(s -> s.getEdat() < 30 && s.getTitols().contains("Llicenciatura"))
                .limit(1)
                .collect(Collectors.collectingAndThen(Collectors.toList(), s -> s.isEmpty() ? "No trobat" : s));
        System.out.println(empleadoMenor30);
        
        Object empleadoMenor40 = EmpleatsDAO.getEmpleats().stream()
                .filter(s -> s.getEdat() < 40 && s.getTitols().contains("Llicenciatura"))
                .limit(1)
                .collect(Collectors.collectingAndThen(Collectors.toList(), s -> s.isEmpty() ? "No trobat" : s));
        System.out.println(empleadoMenor40);
       
        // 36. Obtín un LinkedHashSet dels títols que tenen tots els empleats.
        LinkedHashSet<ArrayList<String>> titolsEmpleats = EmpleatsDAO.getEmpleats().stream()
                .map(Empleat::getTitols)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(titolsEmpleats);
        
        // 37. Obtín un Map amb dos claus, la primera tindrá com a valors una llista dels empleats amb el títol de CFGS i l'altra clau tindrá una llista amb els que no el tenen.

        // 38. A partir d'una llista d'String retorna la mateixa llista pero sense cadenes buides
        List<String> elementsOriginals = List.of("aigua", "", "llet", "oli", "", "  ", "lletuga");
        boolean vacio = elementsOriginals.contains("");
        int vacioIndex = elementsOriginals.indexOf("");
        // elementsOriginals.removeIf(e -> e.contains("aigua")); Por alguna razón ésta línea da error al igual que elementsOriginals.remove(vacioIndex);
        

        // 39. Obtín una cadena separada per comes basada en una llista determinada d'enters. 
        // Cada element ha d'anar precedit de la lletra 'p' si el nombre és parell i precedit de la lletra 'i' si el nombre és imparell. 
        // Per exemple, si la llista d'entrada és (3,44), la eixida hauria de ser 'i3, p44'.
        List<Integer> llistaEnters = List.of(9,23,4,15);
        String ab = "";
        for (int i = 0; i < 4; i++) {
            if ((llistaEnters.get(i) % 2) == 0) {
                ab = ab.concat("p").concat(llistaEnters.get(i) + "");
            } else if ((llistaEnters.get(i) % 2) != 0) {
                ab = ab.concat("i").concat(llistaEnters.get(i) + "");
            }
            if (i != 3) {
                ab = ab.concat(", ");
            }
        }
        System.out.println(ab);
        
        // 40.A partir dels empleats. Obtín un mapa que tinga com a clau el nom del departament i com a valor un altre mapa
        // Este segon mapa tindrà com a clau el cognom de l'empleat y com a valor la llista de títols que té.
        
        // EXTRA A: A partir d'un String retorna les lletres distintes que conté, separades per comes (només lletres, no espais ni números ni altres caracters)
        String frase1 = "Tinc un 8 en PROG";
        String letras1 = "";
        
        for (int i = 0; i < frase1.length(); i++) {
            if ( !(frase1.charAt(i) + "").equals("") &&  !(frase1.charAt(i) + "").equals(" ")){
                if ( !(frase1.charAt(i) + "").equals("1") && !(frase1.charAt(i) + "").equals("2") && !(frase1.charAt(i) + "").equals("3") && !(frase1.charAt(i) + "").equals("4") && !(frase1.charAt(i) + "").equals("5") && !(frase1.charAt(i) + "").equals("6") && !(frase1.charAt(i) + "").equals("7") && !(frase1.charAt(i) + "").equals("8") && !(frase1.charAt(i) + "").equals("9")) {
                    if ( i!=frase1.length()-1 ) {
                        letras1 = letras1.concat(frase1.charAt(i) + ", ");
                    } else {
                        letras1 = letras1.concat(frase1.charAt(i) + ". ");
                    }
                }
            }
        }
        
        System.out.println(letras1);
        
        // EXTRA B: A partir d'un String retorna la quantitat de lletres distintes que conté (només lletres, no espais ni números ni altres caracters)
        String letras2 = "";
        
        for (int i = 0; i < frase1.length(); i++) {
            if ( !(frase1.charAt(i) + "").equals("") &&  !(frase1.charAt(i) + "").equals(" ")){
                if ( !(frase1.charAt(i) + "").equals("1") && !(frase1.charAt(i) + "").equals("2") && !(frase1.charAt(i) + "").equals("3") && !(frase1.charAt(i) + "").equals("4") && !(frase1.charAt(i) + "").equals("5") && !(frase1.charAt(i) + "").equals("6") && !(frase1.charAt(i) + "").equals("7") && !(frase1.charAt(i) + "").equals("8") && !(frase1.charAt(i) + "").equals("9")) {
                    letras2 = letras2.concat(frase1.charAt(i) + "");
                }
            }
        }
        
        System.out.println(letras2);
        System.out.println(letras2.length());
        
        // EXTRA C: Obtín un mapa que mostre com a clau cada lletra distinta del String, i com a valor la quantitat de vegades que apareix.
                
        // EXTRA D: Mostra la lletra amb major freqüencia d'aparicions, i el nombre d'aparicions d'eixa lletra.

    }

}
