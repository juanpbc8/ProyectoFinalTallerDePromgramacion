package SistemaDeMatriculasColegioParticular;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Matricula {
    private static final Scanner scan = new Scanner(System.in);
     
    public static void generarMatricula(Estudiante[] estudiantes) throws ArrayIndexOutOfBoundsException, NullPointerException{
        try{
            System.out.print("Ingrese el número de estudiante a generar matricula: ");
            int n = scan.nextInt();
            scan.nextLine();
            System.out.println("\n------------------------------ MATRICULA DE ESTUDIANTE -------------------------------");
            System.out.println("Nombre del estudiante: "+estudiantes[n-1].getNombreEstudiante()+"\tSexo: "+estudiantes[n-1].getSexo());
            System.out.println("Edad: "+estudiantes[n-1].getEdad()+"\t\tNivel: "+estudiantes[n-1].getNivel()+"\t\tGrado: "+estudiantes[n-1].getGrado());
            System.out.println("Telefono: "+estudiantes[n-1].getTelefono()+"\tCorreo: "+estudiantes[n-1].getCorreoEstudiante());
            System.out.println("Apoderado: "+estudiantes[n-1].getApoderado()+"\tTelefono Apoderado: "+estudiantes[n-1].getTelefonoApoderado());
            System.out.printf("Fecha de matriculacion: %tF",estudiantes[n-1].getFechaMatricula());
            if(estudiantes[n-1].getNivel().equalsIgnoreCase("primaria")){
                Horario.generarHorarioPrimaria();
            }else{
                Horario.generarHorarioSecundaria();
            }
        }catch(NullPointerException e){
            throw new NullPointerException("NO EXISTE ESTUDIANTE");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("NUMERO FUERA DE LIMITES");
        }
    }

    public static void generarMatriculaHTML(Estudiante[] estudiantes)throws ArrayIndexOutOfBoundsException, NullPointerException, FileNotFoundException{
        try{
            System.out.print("Ingrese el número de estudiante a generar matricula HTML: ");
            int n = scan.nextInt();
            scan.nextLine();
            if(estudiantes[n-1].getNivel().equalsIgnoreCase("primaria")){
                String contenidoHtml = "<!DOCTYPE html>" +
                    "<head>" +
                      "<title> MATRICULA </title>" +
                      "<style>" +
                      "caption {"+
                          "padding: 20px;"+
                          "font-size: 28px;}"+
                      "th {"+
                          "background-color: #0096c7;"+
                          "color: #03045e;}"+
                      "td {"+
                          "background-color: #48cae4;"+
                          "padding: 8px;"+
                          "text-align: center;}"+  
                      "h1 {"+
                          "padding: 20px;"+
                          "font-size: 28px;}"+
                      "p {"+
                          "padding: 5px;"+
                          "margin: 0;" +
                          "font-size: 20px;}"+
                      "</style>" +
                    "</head>" +
                    "<body>" +
                        "<h1> MATRICULA DE ESTUDIANTE </h1>" +
                        "<div style=\"float: left; margin-right: 10px;\">" +
                            "<img src=\"C:\\Users\\juanp\\OneDrive\\Documentos\\Taller de Programacion (Java)\\Imagenes\\FotoEstudiantes\\Nino.png\" alt=\"\">" +
                        "</div>" +
                        "<div style=\"margin-left: 200px;\">" +
                            "<p><b>Nombre del estudiante:</b> "+estudiantes[n-1].getNombreEstudiante()+ "</p>"+
                            "<p><b>Sexo:</b> "+estudiantes[n-1].getSexo()+"</p>" + 
                            "<p><b>Edad:</b> "+estudiantes[n-1].getEdad()+"</p>"+
                            "<p><b>Nivel:</b> "+estudiantes[n-1].getNivel()+ "</p>"+
                            "<p><b>Grado:</b> "+estudiantes[n-1].getGrado()+"</p>" +
                        "</div>" +
                            "<p><b>Telefono:</b> "+estudiantes[n-1].getTelefono()+"</p>"+
                            "<p><b>Correo:</b> "+estudiantes[n-1].getCorreoEstudiante()+"</p>" + 
                            "<p><b>Apoderado:</b> "+estudiantes[n-1].getApoderado()+ "</p>"+
                            "<p><b>Telefono Apoderado:</b> "+estudiantes[n-1].getTelefonoApoderado()+"</p>" + 
                            "<p><b>Fecha de matriculacion:</b> 07-12-2023 </p>" +
                      "<table>" +
                        "<thead>" +
                          "<caption>" +
                            " HORARIO DE CLASES " +
                          "</caption>" +
                          "<th>HORA</th>" +
                          "<th>LUNES</th>" +
                          "<th>MARTES</th>" +
                          "<th>MIERCOLES</th>" +
                          "<th>JUEVES</th>" +
                          "<th>VIERNES</th>" +
                        "</thead>" +
                        "<tbody>" +
                          "<tr>" +
                            "<td>7:40 - 8:00</td>" +
                            "<td colspan =\"5\"> ACTIVIDADES PERMANENTES </td>" +
                          "</tr>"+
                          "<tr>"+
                            "<td>8:00 - 9:30</td>"+
                            "<td> COMUNICACION </td>"+
                            "<td> RELIGION </td>"+
                            "<td> MATEMATICA </td>"+
                            "<td> PERSONAL SOCIAL </td>"+
                            "<td> MATEMATICA </td>"+
                          "</tr>"+
                          "<tr>"+
                            "<td>9:45 - 11:45</td>"+
                            "<td> MATEMATICA </td>"+
                            "<td> EDU. FISICA </td>"+
                            "<td> CIENCIA Y AMB </td>"+
                            "<td> COMUNICACION </td>"+
                            "<td> COMUNICACION </td>"+
                          "</tr>"+
                          "<tr>"+
                            "<td>11:15 - 11:45</td>"+
                            "<td colspan =\"5\"> RECREO </td>"+
                          "</tr>"+
                          "<tr>"+
                            "<td>12:00 - 13:30</td>"+
                              "<td> MUSICA </td>"+
                             "<td> INGLES </td>"+
                            "<td> ARTE </td>"+
                            "<td> COMPUTACION </td>"+
                            "<td> MINI CHEF </td>"+
                          "</tr>"+
                        "</tbody>"+
                        "<tfoot>"+
                        "</tfoot>"+
                      "</table>"+
                    "</body>"+
                  "</html>";

                  contenidoHtml += "</table></body></html>";

                  String rutaDelArchivo = "C:\\Users\\juanp\\OneDrive\\Documentos\\Taller de Programacion (Java)\\MatriculaPrimaria.html";
                  try(PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                      out.println(contenidoHtml);
                      System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
                  }catch(FileNotFoundException e){
                  }
            }else{
                String contenidoHtml = "<!DOCTYPE html>" +
                "<head>" +
                  "<title> MATRICULA </title>" +
                  "<style>" +
                  "caption {"+
                      "padding: 20px;"+
                      "font-size: 28px;}"+
                  "th {"+
                      "background-color: #0096c7;"+
                      "color: #03045e;}"+
                  "td {"+
                      "background-color: #48cae4;"+
                      "padding: 8px;"+
                      "text-align: center;}"+  
                  "h1 {"+
                      "padding: 20px;"+
                      "font-size: 28px;}"+
                  "p {"+
                      "padding: 5px;"+
                      "margin: 0;" +
                      "font-size: 20px;}"+
                  "</style>" +
                "</head>" +
                "<body>" +
                      "<h1> MATRICULA DE ESTUDIANTE </h1>" +
                      "<div style=\"float: left; margin-right: 10px;\">" +
                          "<img src=\"C:\\Users\\juanp\\OneDrive\\Documentos\\Taller de Programacion (Java)\\Imagenes\\FotoEstudiantes\\Mujer.jpg\" alt=\"\">" +
                      "</div>" +
                      "<div style=\"margin-left: 200px;\">" +
                          "<p><b>Nombre del estudiante:</b> "+estudiantes[n-1].getNombreEstudiante()+ "</p>"+
                          "<p><b>Sexo:</b> "+estudiantes[n-1].getSexo()+"</p>" + 
                          "<p><b>Edad:</b> "+estudiantes[n-1].getEdad()+"</p>"+
                          "<p><b>Nivel:</b> "+estudiantes[n-1].getNivel()+ "</p>"+
                          "<p><b>Grado:</b> "+estudiantes[n-1].getGrado()+"</p>" + 
                      "</div>" +
                          "<p><b>Telefono:</b> "+estudiantes[n-1].getTelefono()+ "</p>"+
                          "<p><b>Correo:</b> "+estudiantes[n-1].getCorreoEstudiante()+"</p>" + 
                          "<p><b>Apoderado:</b> "+estudiantes[n-1].getApoderado()+ "</p>"+
                          "<p><b>Telefono Apoderado:</b> "+estudiantes[n-1].getTelefonoApoderado()+"</p>" + 
                          "<p><b>Fecha de matriculacion:</b> 07-12-2023</p>" +
                  "<table>" +
                    "<thead>" +
                      "<caption>" +
                        " HORARIO DE CLASES " +
                      "</caption>" +
                      "<th> HORA </th>" +
                      "<th> LUNES </th>" +
                      "<th> MARTES </th>" +
                      "<th> MIERCOLES </th>" +
                      "<th> JUEVES </th>" +
                      "<th> VIERNES </th>" +
                    "</thead>" +
                    "<tbody>" +
                      "<tr>" +
                        "<td>7:40 - 8:00</td>" +
                        "<td colspan =\"5\"> ACTIVIDADES PERMANENTES </td>"+
                      "</tr>"+
                      "<tr>"+
                        "<td>8:00 - 9:30</td>"+
                        "<td> ALGEBRA </td>"+
                        "<td> TRIGONOMETRIA </td>"+
                        "<td> HIST. DEL PERÚ </td>"+
                        "<td> RAZ. MATEMATICO </td>"+
                        "<td> QUIMICA </td>"+
                      "</tr>"+
                      "<tr>"+
                        "<td>9:45 - 11:45</td>"+
                        "<td> LENGUAJE </td>"+
                        "<td> EDU. FISICA </td>"+
                        "<td> GEOMETRIA </td>"+
                        "<td> HIST. UNIVERSAL </td>"+
                        "<td> BIOLOGIA </td>"+
                      "</tr>"+
                      "<tr>"+
                        "<td>11:15 - 11:45</td>"+
                        "<td colspan =\"5\"> RECREO </td>"+
                      "</tr>"+
                      "<tr>"+
                        "<td>12:00 - 13:30</td>"+
                        "<td> ARITMETICA </td>"+
                        "<td> LITERATURA </td>"+
                        "<td> RAZ. VERBAL </td>"+
                        "<td> COMPUTACION </td>"+
                        "<td> FISICA </td>"+
                    "</tbody>"+
                    "<tfoot>"+
                    "</tfoot>"+
                  "</table>"+
                "</body>"+
              "</html>";

              contenidoHtml += "</table></body></html>";

                String rutaDelArchivo = "C:\\Users\\juanp\\OneDrive\\Documentos\\Taller de Programacion (Java)\\MatriculaSecundaria.html";
                try(PrintWriter out = new PrintWriter(rutaDelArchivo)) {
                    out.println(contenidoHtml);
                    System.out.println("Informe HTML generado y guardado en: " + rutaDelArchivo);
                }catch(FileNotFoundException e){
                }
            }
        }catch(NullPointerException e){
            throw new NullPointerException("NO EXISTE ESTUDIANTE");
        }catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayIndexOutOfBoundsException("NUMERO FUERA DE LIMITES");
        }
    }
    
    public static void verEstudiantesMatriculadosHTML(Estudiante[] estudiantes) throws NullPointerException, FileNotFoundException{
        String contenidoHTML = "<!DOCTYPE html>"+
                "<head><title>ESTUDIANTES MATRICULADOS</title>"+
                "<style>"+
                "caption {"+
                      "padding: 20px;"+
                      "font-size: 28px;}"+
                "table, th, td {"+
                    "border: 3px solid black;"+
                    "border-collapse: collapse;}"+
                "th, td {"+
                    "padding: 20px;}"+
                "</style></head>"+
                "<body><table>"+
                "<caption>ESTUDIANTES MATRICULADOS</caption>"+
                "<tr>" +
                "<th>NOMBRE</th>"+
                "<th>EDAD</th>"+
                "<th>NIVEL</th>"+
                "<th>GRADO</th>"+
                "</tr>";
                try{
                    for(int i=0;i<estudiantes.length;i++){
                        contenidoHTML += "<tr>"+
                                "<td>"+estudiantes[i].getNombreEstudiante()+"</td>"+
                                "<td>"+estudiantes[i].getEdad()+"</td>"+
                                "<td>"+estudiantes[i].getNivel()+"</td>"+
                                "<td>"+estudiantes[i].getGrado()+"</td>"+
                                "</tr>";
                    }
                }catch(NullPointerException e){
                }
                
                contenidoHTML += "</table></body></html>";
                
                String rutaDelArchivo = "C:\\Users\\juanp\\OneDrive\\Documentos\\Taller de Programacion (java)\\EstudiantesMatriculados.html";
                try(PrintWriter out = new PrintWriter(rutaDelArchivo)){
                    out.println(contenidoHTML);
                    System.out.println("Informe HTML generado y guardado en: "+rutaDelArchivo);
                }catch(FileNotFoundException e){
                }
    }
}
