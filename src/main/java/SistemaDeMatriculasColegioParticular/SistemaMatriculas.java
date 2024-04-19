package SistemaDeMatriculasColegioParticular;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class SistemaMatriculas {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String opcion1, opcion2;
        int estudiantesMatriculados = 0;
        Estudiante[] estudiantes = new Estudiante[220];//MAXIMA CAPACIDAD DE ESTUDIANTES DEL COLEGIO (20 por salon)
        Docente[] docentesPrimaria = new Docente[11];//MAXIMA CAPACIDAD DE DOCENTES PRIMARIA DEL COLEGIO
        Docente[] docentesSecundaria = new Docente[15];//MAXIMA CAPACIDAD DE DOCENTES SECUNDARIA DEL COLEGIO
        //DOCENTES PREDERTERMINADOS PRIMARIA
        docentesPrimaria[0] = new Docente("Ana García", "Comunicacion", "anagarci@gmail.com", 912345158,"Primaria");
        docentesPrimaria[1] = new Docente("Luis Pérez", "Matematicas", "luisperez@gmail.com", 998567890,"Primaria");
        docentesPrimaria[2] = new Docente("Carla López", "Personal Social", "carlalopez@gmail.com", 978615321,"Primaria");
        docentesPrimaria[3] = new Docente("Marina Torres", "Ciencia y Ambiente", "marinatorre@gmail.com", 967456123,"Primaria");
        docentesPrimaria[4] = new Docente("Daniel Ruiz", "Religion", "danielruiz@gmail.com", 929254567,"Primaria");
        docentesPrimaria[5] = new Docente("Mario Diaz", "Computacion", "mariodiaz@gmail.com", 945671971,"Primaria");
        docentesPrimaria[6] = new Docente("Paula Ortega", "Ingles", "pauortega@gmail.com", 956478901,"Primaria");
        docentesPrimaria[7] = new Docente("Elena Díaz", "Musica", "elenadiaz@gmail.com", 945673451,"Primaria");
        docentesPrimaria[8] = new Docente("Javier Núñez", "Arte", "javicho@gmail.com", 915326489,"Primaria");
        docentesPrimaria[9] = new Docente("Maya López", "MiniChef", "mayita@gmail.com", 936528745,"Primaria");
        docentesPrimaria[10] = new Docente("Roberto Perez", "Edu. Fisica", "robertope@gmail.com", 965231695,"Primaria");   
        //DOCENTES PREDERTERMINADOS SECUNDARIA 
        docentesSecundaria[0] = new Docente("Alberto Tamariz", "Algebra", "albertotamariz@gmail.com", 912345678, "Secundaria");
        docentesSecundaria[1] = new Docente("Pedro Soto", "Aritmetica", "pedrosoto@gmail.com", 934567890,"Secundaria");
        docentesSecundaria[2] = new Docente("Maria Olortegui", "Trigonometria", "mariaolorte@gmail.com", 978654321,"Secundaria");
        docentesSecundaria[3] = new Docente("Luis Meza", "Geometria", "luismeza@gmail.com", 967890123,"Secundaria");
        docentesSecundaria[4] = new Docente("Marco Polo", "Raz. Matematico", "marcopolo@gmail.com", 921234567,"Secundaria");
        docentesSecundaria[5] = new Docente("Miguel Osorio", "Lenguaje", "migueloso@gmail.com", 945678901,"Secundaria");
        docentesSecundaria[6] = new Docente("Thomas Henry", "Literatura", "thomashenry@gmail.com", 956789012,"Secundaria");
        docentesSecundaria[7] = new Docente("Nelly Orozco", "Raz. Verbal", "nellyoro@gmail.com", 923456789,"Secundaria");
        docentesSecundaria[8] = new Docente("Rodrigo Leon", "Fisica", "rodrigoleon@gmail.com", 987012345,"Secundaria");
        docentesSecundaria[9] = new Docente("Franco Moran", "Quimica", "francomora@gmail.com", 964321789,"Secundaria");
        docentesSecundaria[10] = new Docente("Fabrizio Lopez", "Biologia", "fabriziolopez@gmail.com", 932187654,"Secundaria");
        docentesSecundaria[11] = new Docente("Linder Masco", "Hist. Universal", "lindermas@gmail.com", 915647895,"Secundaria");
        docentesSecundaria[12] = new Docente("Manuel Gaspar", "Hist. del Peru", "manuelgas@gmail.com", 947895656,"Secundaria");
        docentesSecundaria[13] = new Docente("Mauricio Flores", "Edu. Fisica", "mauflores@gmail.com", 915632654,"Secundaria");
        docentesSecundaria[14] = new Docente("Juan Gomes", "Computacion", "juangomes@gmail.com", 945632195,"Secundaria");
        
        String menu1 = """
                       
                      ----- MENU DEL SISTEMA ----
                      [1] Gestion Estudiantes
                      [2] Gestion Docentes
                      [3] Generar Matricula
                      [4] Generar Matricula HTML
                      [5] Salir del Sistema""";
        String menu2 = """
                       
                      ----- GESTION DE ESTUDIANTES ----
                      [1] Registrar Nuevo Estudiante
                      [2] Informacion de Contacto
                      [3] Ver Estudiantes Matriculados
                      [4] Ver Estudiantes Matriculados HTML
                      [5] Eliminar Estudiante
                      [6] Salir de Gestion Estudiantes""";
        String menu3 = """
                       
                      ----- GESTION DE DOCENTES ----
                      [1] Registrar Nuevo Docente
                      [2] Ver Plana Docente
                      [3] Eliminar Docente
                      [4] Salir de Gestion Docentes""";
        do{
            System.out.println("\n---- BIENVENIDO AL SISTEMA DE MATRICULA ----");
            System.out.println("Estudiantes Matriculados : "+estudiantesMatriculados+"(Max. 220)");
            System.out.println(menu1);
            System.out.print("Ingrese una opcion: ");
            opcion1 = sc.nextLine();
            switch(opcion1){
                case "1" -> {//GESTION ESTUDIANTES
                    do{
                        System.out.println(menu2);
                        System.out.print("Ingrese una opcion: ");
                        opcion2 = sc.nextLine();
                        switch(opcion2){
                            case "1" -> {//REGISTRAR NUEVO ESTUDIANTE
                                Estudiante.registrarEstudiante(estudiantes);
                                estudiantesMatriculados++;
                            }
                            case "2" -> {//MOSTRAR INFORMACION DE CONTACTO DE UN ESTUDIANTE
                                try{
                                    Estudiante.verEstudiantesMatriculados(estudiantes);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }
                                try{
                                    Estudiante.mostrarInformacionContacto(estudiantes);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }catch(ArrayIndexOutOfBoundsException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }
                            case "3" -> {//VER ESTUDIANTES MATRICULADOS
                                try{
                                    Estudiante.verEstudiantesMatriculados(estudiantes);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }
                            case "4" -> {//VER ESTUDIANTES MATRICULADOS HTML
                                try{
                                    Matricula.verEstudiantesMatriculadosHTML(estudiantes);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }catch(FileNotFoundException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }
                            case "5" -> {//ELIMINAR ESTUDIANTE
                                try{
                                    Estudiante.verEstudiantesMatriculados(estudiantes);    
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }
                                try{
                                    Estudiante.eliminarEstudiante(estudiantes);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }catch(ArrayIndexOutOfBoundsException ex){
                                    System.out.println(ex.getMessage());
                                }
                                estudiantesMatriculados--;
                            }
                            case "6" -> {System.out.println("VOLVIENDO ATRAS...");}
                            default -> {System.out.println("Opcion invalida");}
                        }
                    }while(!opcion2.equals("6"));
                }
                case "2" ->{//GESTION DOCENTES
                    do{
                        System.out.println(menu3);
                        System.out.print("Ingrese una opcion: ");
                        opcion2 = sc.nextLine();
                        switch(opcion2){
                            case "1" -> {//REGISTRAR NUEVO DOCENTE
                                Docente.registrarDocente(docentesPrimaria, docentesSecundaria);
                            }
                            case "2" -> {//VER PLANA DOCENTE
                                try{
                                    Docente.verDocentesPrimaria(docentesPrimaria);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }
                                try{
                                    Docente.verDocentesSecundaria(docentesSecundaria);
                                }catch(NullPointerException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }
                            case "3" -> {//ELIMINAR DOCENTE
                                try{
                                    Docente.eliminarDocente(docentesPrimaria, docentesSecundaria);
                                }catch(ArrayIndexOutOfBoundsException ex){
                                    System.out.println(ex.getMessage());
                                }
                            }
                            case "4" -> {System.out.println("VOLVIENDO ATRAS...");}
                            default -> {System.out.println("Opcion invalida");}
                        }
                    }while(!opcion2.equals("4"));
                }
                case "3" -> {//GENERAR MATRICULA
                    try{
                        Estudiante.verEstudiantesMatriculados(estudiantes);
                    }catch(NullPointerException ex){
                        System.out.println(ex.getMessage());
                    }
                    try{
                        Matricula.generarMatricula(estudiantes);
                    }catch(NullPointerException ex){
                        System.out.println(ex.getMessage());
                    }catch(ArrayIndexOutOfBoundsException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                case "4" -> {//GENERAR MATRICULA HTML
                    try{
                        Estudiante.verEstudiantesMatriculados(estudiantes);
                    }catch(NullPointerException ex){
                        System.out.println(ex.getMessage());
                    }
                    try{
                        Matricula.generarMatriculaHTML(estudiantes);
                    }catch(NullPointerException ex){
                        System.out.println(ex.getMessage());
                    }catch(ArrayIndexOutOfBoundsException | FileNotFoundException ex){
                        System.out.println(ex.getMessage());
                    }
                }
                default -> {System.out.println("CERRANDO SISTEMA");}
            }
        }while(!opcion1.equals("5"));
        sc.close();
    }
}
