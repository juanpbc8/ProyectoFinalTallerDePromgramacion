package SistemaDeMatriculasColegioParticular;
import java.util.Scanner;
public class Docente {
    private String nombreDocente;
    private String especialidad;
    private String correoDocente;
    private long telefono;
    private String nivel;
    private static final Scanner scan = new Scanner(System.in);
    
    public Docente(String nombreDocente, String especialidad, String correoDocente, long telefono, String nivel) {
        this.nombreDocente = nombreDocente;
        this.especialidad = especialidad;
        this.correoDocente = correoDocente;
        this.telefono = telefono;
        this.nivel = nivel;
    }

    public static void verDocentesPrimaria(Docente[] docentesPrimaria) throws NullPointerException{
        try{
            System.out.println("\n------------- LISTA DE DOCENTES PRIMARIA  -------------");
            System.out.println("NOMBRE\t\t\t\tNIVEL      ESPECIALIDAD\t\t TELEFONO            CORREO");
            for(int i=0;i<docentesPrimaria.length;i++){
                System.out.printf((i+1)+". %-25s  %-11s  %-20s  %-11d  %-30s\n",
                    docentesPrimaria[i].getNombreDocente(),docentesPrimaria[i].getNivel(),
                    docentesPrimaria[i].getEspecialidad(),docentesPrimaria[i].getTelefono(),
                    docentesPrimaria[i].getCorreoDocente());
            }
        }catch (NullPointerException e){
            throw new NullPointerException("");
        }
    }
    public static void verDocentesSecundaria(Docente[] docentesSecundaria) throws NullPointerException{
        try{
            System.out.println("\n------------- LISTA DE DOCENTES SECUNDARIA  -------------");
            System.out.println("NOMBRE\t\t\t\tNIVEL      ESPECIALIDAD\t\t TELEFONO            CORREO");
            for(int i=0;i<docentesSecundaria.length;i++){
                System.out.printf((i+1)+". %-25s  %-11s  %-20s  %-11d  %-30s\n",
                    docentesSecundaria[i].getNombreDocente(),docentesSecundaria[i].getNivel(),
                    docentesSecundaria[i].getEspecialidad(),docentesSecundaria[i].getTelefono(),
                    docentesSecundaria[i].getCorreoDocente());
            }
        }catch (NullPointerException e){
            throw new NullPointerException("");
        }
    }
    public static void eliminarDocente(Docente[] docentesPrimaria, Docente[] docentesSecundaria) 
            throws ArrayIndexOutOfBoundsException{
        System.out.print("Ingrese nivel academico del docente a eliminar: ");
        String opcion = scan.nextLine();
        if(opcion.equalsIgnoreCase("primaria")){
            Docente.verDocentesPrimaria(docentesPrimaria);
            try{
                System.out.print("Ingrese el número de docente a eliminar: ");
                int n = scan.nextInt();
                scan.nextLine();
                if(docentesPrimaria[n-1] == null){
                    System.out.println("NO EXISTE DOCENTE");
                }else{
                    for(int i=n-1;i<docentesPrimaria.length-1;i++){
                        docentesPrimaria[i] = docentesPrimaria[i+1];
                    }
                    docentesPrimaria[docentesPrimaria.length-1] = null;
                    System.out.println("DOCENTE ELIMINADO CON EXITO");
                }
            }catch(ArrayIndexOutOfBoundsException e){
                throw new ArrayIndexOutOfBoundsException("NUMERO FUERA DE LIMITES");
            }
        }else{
            if(opcion.equalsIgnoreCase("secundaria")){
                Docente.verDocentesSecundaria(docentesSecundaria);
                try{
                    System.out.print("Ingrese el número de docente a eliminar: ");
                    int n = scan.nextInt();
                    scan.nextLine();
                    if(docentesSecundaria[n-1] == null){
                        System.out.println("NO EXISTE DOCENTE");
                    }else{
                        for(int i=n-1;i<docentesSecundaria.length-1;i++){
                            docentesSecundaria[i] = docentesSecundaria[i+1];
                        }
                        docentesSecundaria[docentesSecundaria.length-1] = null;
                        System.out.println("DOCENTE ELIMINADO CON EXITO");
                    }
                }catch(ArrayIndexOutOfBoundsException e){
                    throw new ArrayIndexOutOfBoundsException("NUMERO FUERA DE LIMITES");
                }
            }else{
                System.out.println("Escriba: Primaria o Secundaria");
            }
        }
    }
    
    public static void registrarDocente(Docente[] docentesPrimaria, Docente[] docentesSecundaria){
        System.out.print("Ingrese el nivel academico: ");
        String nivel = scan.nextLine();
        if(nivel.equalsIgnoreCase("primaria")){
            boolean docentesPrimariaLleno = true;
            for(int j=0;j<docentesPrimaria.length;j++){
                if(docentesPrimaria[j] == null){
                    docentesPrimariaLleno = false;
                    break;
                }
            }
            if(docentesPrimariaLleno){
                System.out.println("Docentes de primaria completos, elimine a un docente para registrar a uno nuevo");
            }else{
                for(int i=0;i<docentesPrimaria.length;i++){
                    if(docentesPrimaria[i] == null){
                        long telefono;
                        System.out.print("Ingrese nombre del docente: ");
                        String nombreDocente = scan.nextLine();
                        System.out.print("Ingrese especialidad del docente: ");
                        String especialidad = scan.nextLine();
                        System.out.print("Ingrese correo del docente: ");
                        String correoDocente = scan.nextLine();
                        while(true){
                            System.out.print("Telefono: ");
                            if(scan.hasNextLong()){
                                telefono = scan.nextLong();
                                scan.nextLine();
                                if(telefono < 900000000 || telefono > 999999999){
                                    System.out.println("El telefono debe tener 9 cifras y empezar con 9");
                                }else{
                                    break;
                                }
                            }else{
                                System.out.println("Ingrese un número valido");
                                scan.nextLine();
                            }
                        }
                        docentesPrimaria[i] = new Docente(nombreDocente, especialidad, correoDocente, 
                                telefono, "Primaria");
                        System.out.println("DOCENTE PRIMARIA REGISTRADO CON EXITO");
                        break;
                    }
                }
            }
        }else{
            if(nivel.equalsIgnoreCase("secundaria")){
                boolean docentesSecundariaLleno = true;
                for(int i=0;i<docentesSecundaria.length;i++){
                    if(docentesSecundaria[i] == null){
                        docentesSecundariaLleno = false;
                        break;
                    }
                }
                if(docentesSecundariaLleno){
                    System.out.println("Docentes de secundaria completos, elimine a un docente para registrar a uno nuevo");
                }else{
                    for(int i=0;i<docentesSecundaria.length;i++){
                        if(docentesSecundaria[i] == null){
                            long telefono;
                            System.out.print("Ingrese nombre del docente: ");
                            String nombreDocente = scan.nextLine();
                            System.out.print("Ingrese especialidad del docente: ");
                            String especialidad = scan.nextLine();
                            System.out.print("Ingrese correo del docente: ");
                            String correoDocente = scan.nextLine();
                            while(true){
                                System.out.print("Telefono: ");
                                if(scan.hasNextLong()){
                                    telefono = scan.nextLong();
                                    scan.nextLine();
                                    if(telefono < 900000000 || telefono > 999999999){
                                        System.out.println("El telefono debe tener 9 cifras y empezar con 9");
                                    }else{
                                        break;
                                    }
                                }else{
                                    System.out.println("Ingrese un número valido");
                                    scan.nextLine();
                                }
                            }
                            docentesPrimaria[i] = new Docente(nombreDocente, especialidad, correoDocente,
                                    telefono, "Secundaria");
                            System.out.println("DOCENTE SECUNDARIA REGISTRADO CON EXITO");
                            break;
                        }
                    }
                }
            }
        }
    }
    public String getNombreDocente() {
        return nombreDocente;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public String getCorreoDocente() {
        return correoDocente;
    }
    public long getTelefono() {
        return telefono;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    public void setCorreoDocente(String correoDocente) {
        this.correoDocente = correoDocente;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
