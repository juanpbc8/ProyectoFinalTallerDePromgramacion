package SistemaDeMatriculasColegioParticular;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Estudiante {
    private String nombreEstudiante;
    private char sexo;
    private int edad;
    private String grado;
    private String nivel;
    private long telefono;
    private String direccion;
    private String correoEstudiante;
    private String apoderado;
    private long telefonoApoderado;
    private Date fechaMatricula;
    private static final Scanner scan = new Scanner(System.in);

    public Estudiante(String nombreEstudiante, char sexo, int edad, String grado, String nivel, long telefono, String direccion, String correoEstudiante, 
            String apoderado, long telefonoApoderado) throws InputMismatchException {
        this.nombreEstudiante = nombreEstudiante;
        this.sexo = sexo;
        this.edad = edad;
        this.grado = grado;
        this.nivel = nivel;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correoEstudiante = correoEstudiante;
        this.apoderado = apoderado;
        this.telefonoApoderado = telefonoApoderado;
        this.fechaMatricula = new Date();
    }
    
    public static void registrarEstudiante(Estudiante[] estudiantes){
        boolean estudiantesLleno = true;
        for(int j=0;j<estudiantes.length;j++){
            if(estudiantes[j] == null){
                estudiantesLleno = false;
                break;
            }
        }
        if(estudiantesLleno){
            System.out.println("Estudiantes Completos");
        }else{
            for(int i=0;i<estudiantes.length;i++){
                if(estudiantes[i] == null){
                    String nombreEstudiante;
                    char sexo;
                    int edad = 0;
                    String nivel = null;
                    String grado = null;
                    long telefono;
                    long telefonoApoderado;
                    int opcion_nivel;
                    int opcion_grado;

                    System.out.println("\n---------- REGISTRAR ESTUDIANTE ----------");
                    System.out.print("Nombre del estudiante: ");
                    nombreEstudiante = scan.nextLine().toUpperCase();
                    
                    while(true){
                        System.out.print("Sexo: ");
                        sexo = scan.nextLine().toUpperCase().charAt(0);
                        if(sexo == 'M' || sexo == 'F'){
                            break;
                        }else{
                            System.out.println("Entrada invalida");
                        }
                    }
                    
                    while(true){
                        System.out.print("Edad: ");
                        if(scan.hasNextInt()){
                            edad = scan.nextInt();
                            scan.nextLine();
                            if(edad < 6 || edad > 18){
                                System.out.println("La edad debe estar entre 6 y 18 años");
                            }else{
                                break;
                            }
                        }else{
                            System.out.println("Ingrese un número");
                            scan.nextLine();
                        }
                    }

                    System.out.println("""
                                       ----- NIVEL -----
                                       [1] Primaria
                                       [2] Secundaria""");
                    while(true){
                        System.out.print("Ingrese nivel de educación: ");
                        if(scan.hasNextInt()){
                            opcion_nivel = scan.nextInt();
                            scan.nextLine();
                            if(opcion_nivel < 1 || opcion_nivel > 2){
                                System.out.println("Ingrese una opcion valida");
                            }else{
                                break;
                            }
                        }else{
                            System.out.println("Ingrese un número");
                            scan.nextLine();
                        }
                    }

                    switch (opcion_nivel) {
                        case 1 -> {
                            nivel = "Primaria";
                            System.out.println("""
                                               ----- GRADO -----
                                               [1] 1er grado
                                               [2] 2do grado
                                               [3] 3er grado
                                               [4] 4to grado
                                               [5] 5to grado
                                               [6] 6to grado""");
                            while(true){
                                System.out.print("Ingrese grado academico: ");
                                if(scan.hasNextInt()){
                                    opcion_grado = scan.nextInt();
                                    scan.nextLine();
                                    if(opcion_grado < 1 || opcion_grado > 6){
                                        System.out.println("Ingrese una opcion valida ");
                                    }else{
                                        break;
                                    }
                                }else{
                                    System.out.println("Ingrese un numero");
                                    scan.nextLine();
                                }
                            }
                                switch(opcion_grado){
                                    case 1 -> {grado = "1er grado";}
                                    case 2 -> {grado = "2do grado";}
                                    case 3 -> {grado = "3er grado";}
                                    case 4 -> {grado = "4to grado";}
                                    case 5 -> {grado = "5to grado";}
                                    case 6 -> {grado = "6to grado";}
                                }
                        }
                        case 2 -> {
                            nivel = "Secundaria";
                            System.out.println("""
                                               ----- GRADO -----
                                                [1] 1er año
                                                [2] 2do año
                                                [3] 3er año
                                                [4] 4to año
                                                [5] 5to año""");
                            while(true){
                                System.out.print("Ingrese grado academico: ");
                                if(scan.hasNextInt()){
                                    opcion_grado = scan.nextInt();
                                    scan.nextLine();
                                    if(opcion_grado < 1 || opcion_grado > 5){
                                        System.out.println("Ingrese una opcion valida ");
                                    }else{
                                        break;
                                    }
                                }else{
                                    System.out.println("Ingrese un numero");
                                    scan.nextLine();
                                }
                            }
                            switch(opcion_grado){
                                case 1 -> {grado = "1er año";}
                                case 2 -> {grado = "2do año";}
                                case 3 -> {grado = "3er año";}
                                case 4 -> {grado = "4to año";}
                                case 5 -> {grado = "5to año";}
                            }
                        }
                    }
                    
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
                    
                    System.out.print("Correo electronico: ");
                    String correoEstudiante = scan.nextLine();
                    
                    System.out.print("Direccion: ");
                    String direccion = scan.nextLine();
                    
                    System.out.print("Apoderado: ");
                    String apoderado = scan.nextLine().toUpperCase();
                    
                    while(true){
                        System.out.print("Telefono del apoderado: ");
                        if(scan.hasNextLong()){
                            telefonoApoderado = scan.nextLong();
                            scan.nextLine();
                            if(telefonoApoderado < 900000000 || telefonoApoderado > 999999999){
                                System.out.println("El telefono debe tener 9 cifras y empezar con 9");
                            }else{
                                break;
                            }
                        }else{
                            System.out.println("Ingrese un número valido");
                            scan.nextLine();
                        }
                    }
                    
                    estudiantes[i] = new Estudiante(nombreEstudiante, sexo, edad, grado, nivel, telefono, direccion, correoEstudiante, 
                            apoderado, telefonoApoderado);
                    System.out.println("ESTUDIANTE MATRICULADO CON EXITO");
                    break;
                }
            }
        }
    }
    
    public static void eliminarEstudiante(Estudiante[] estudiantes) throws ArrayIndexOutOfBoundsException, NullPointerException{
        try{
            System.out.print("Ingrese el número de estudiante a eliminar: ");
            int n = scan.nextInt();
            scan.nextLine();
            if(estudiantes[n-1] == null){
                System.out.println("NO EXISTE ESTUDIANTE");
            }else{
                estudiantes[n-1] = null;
                for(int i=n-1;i<estudiantes.length-1;i++){
                    estudiantes[i] = estudiantes[i+1];
                }
                System.out.println("ESTUDIANTE ELIMINADO CON EXITO");
            }
        }catch(NullPointerException e){
            throw new NullPointerException("NO EXISTE ESTUDIANTE");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("NUMERO FUERA DE LIMITES");
        }
    }
    
    public static void mostrarInformacionContacto(Estudiante[] estudiantes) throws ArrayIndexOutOfBoundsException, NullPointerException{
        try{
            System.out.print("Ingrese el numero de estudiante para ver informacion: ");
            int n = scan.nextInt();
            scan.nextLine();
            System.out.println("\n-------- INFORMACION DE CONTACTO --------");
            System.out.println("ESTUDIANTE: "+estudiantes[n-1].getNombreEstudiante());
            System.out.println("Telefono: "+estudiantes[n-1].getTelefono());
            System.out.println("E-mail: "+estudiantes[n-1].getCorreoEstudiante());
            System.out.println("Direccion: "+estudiantes[n-1].getDireccion());
            System.out.println("Apoderado: "+estudiantes[n-1].getApoderado());
            System.out.println("Telefono de apoderado: "+estudiantes[n-1].getTelefonoApoderado());
        }catch(NullPointerException e){
            throw new ArrayIndexOutOfBoundsException("NO EXISTE ESTUDIANTE");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("NUMERO FUERA DE LIMITES");
        }    
    }
    
    public static void verEstudiantesMatriculados(Estudiante[] estudiantes) throws NullPointerException{
        try{
            System.out.println("-------- LISTA DE ESTUDIANTES MATRICULADOS --------");
            System.out.println("NOMBRE\t\t\t\tEDAD      NIVEL      GRADO       FECHA");
            for(int i=0;i<estudiantes.length;i++){
                System.out.printf((i+1)+". %-28s  %-4d  %-11s  %-9s  %tF\n",
                    estudiantes[i].getNombreEstudiante(),estudiantes[i].getEdad(),estudiantes[i].getNivel(),
                    estudiantes[i].getGrado(),estudiantes[i].getFechaMatricula());
            }
        }catch (NullPointerException e){
            throw new NullPointerException("");
        }
    }
        
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }
    public char getSexo() {
        return sexo;
    }
    public int getEdad() {
        return edad;
    }
    public String getGrado() {
        return grado;
    }
    public long getTelefono() {
        return telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getCorreoEstudiante() {
        return correoEstudiante;
    }
    public String getApoderado() {
        return apoderado;
    }
    public long getTelefonoApoderado() {
        return telefonoApoderado;
    }
    public Date getFechaMatricula() {
        return fechaMatricula;
    }
    public String getNivel() {
        return nivel;
    }
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setGrado(String grado) {
        this.grado = grado;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setCorreoEstudiante(String correoEstudiante) {
        this.correoEstudiante = correoEstudiante;
    }
    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }
    public void setTelefonoApoderado(long telefonoApoderado) {
        this.telefonoApoderado = telefonoApoderado;
    }
    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
}

