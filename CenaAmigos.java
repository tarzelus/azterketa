import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.*;




public class CenaAmigos {
		public static void main (String args[]) throws IOException{
			Scanner sc = new Scanner(System.in);

			try 
			{//para escribir en el fichero
			String ruta = "/home/zubiri/Proyectosjava/examen/receta.txt";
 			File archivo2 = new File(ruta);
			FileWriter fw = new FileWriter(archivo2);
			BufferedWriter bw = new BufferedWriter(fw);






			System.out.print("\nIntroduce el numero de recetas: ");

			int num_rec=sc.nextInt();





			ArrayList<Receta> recetas = new ArrayList<Receta>();
			        		ArrayList<Ingrediente> ingredientess = new ArrayList<Ingrediente>();


			for(int t=0; t<num_rec; t++)
        	{
        		System.out.print("\nIntroduce el nombre de la receta: ");
        		Receta receta = new Receta();
        		
        		String nombrereceta=sc.next(); 
        		receta.setNombreReceta(nombrereceta);
        		//bw.write(nombrereceta + ";");

        		System.out.print("\nIntroduce el numero de ingredientes que tiene la receta: ");
        		int num_ingr=sc.nextInt();

 

        		for (int i=0; i<num_rec; i++)
        			{
        			Ingrediente ingrediente = new Ingrediente();
        			System.out.print("\nIntroduce nombre del ingrediente: ");
        			String nombreingrediente=sc.next(); 
        			ingrediente.setNombreIngrediente(nombreingrediente);
        			//bw.write(nombreingrediente + "*");

        			System.out.print("\nIntroduce 1 si es en gramos sino 0: ");
					int engramos=sc.nextInt();	

					
					
					if (engramos==1)
						{
						System.out.print("\nIntroduce los gramos: ");	
						int cantidadgramos=sc.nextInt();
						int cantidadunidad=-1;
						ingrediente.setCantidadGramos(cantidadgramos);
						//bw.write(cantidadgramos + "*");

						ingrediente.setCantidadUnidad(cantidadunidad);

						//bw.write(cantidadunidad + "*");
						}
					else 
						{
						System.out.print("\nIntroduce las unidades: ");
						int cantidadunidad=sc.nextInt();
						int cantidadgramos=-1;
						ingrediente.setCantidadGramos(cantidadgramos);
						ingrediente.setCantidadUnidad(cantidadunidad);
						}


					if (engramos==1)
					{
						boolean tf = true;
						ingrediente.setEnGramos(tf);

						//bw.write("#"+ tf);
					}
					else {
						boolean tf = false;
						ingrediente.setEnGramos(tf);


						//bw.write("#"+ tf+"; ");

					}
					
					ingredientess.add(ingrediente);




        		}

        		System.out.print("\nEscribe como es la preparacion: ");
					String preparar=sc.next();
					//bw.write(preparar);

					
											
					receta.setIngredientes(ingredientess);			
					receta.setPreparacion(preparar);

					recetas.add(receta);
        	}

		for(int r=0; r<recetas.size(); r++)
        {
            bw.write(recetas.get(r).getNombreReceta() + " ");
            ingredientess = recetas.get(r).getIngredientes();
             for(int y=0; y<recetas.size(); y++)
        		{
            	
				bw.append(ingredientess.get(y).getNombreIngrediente()+
				"*"+ingredientess.get(y).getCantidadGramos()+
				"*"+ingredientess.get(y).getCantidadUnidad()+
				"*"+ingredientess.get(y).getEnGramos()+"#");
            
        }	
              bw.write(recetas.get(r).getPreparacion() + "\n");

            
        }	
			









        	bw.close();
        }
        catch (FileNotFoundException e) 
			{
           			 System.out.println(e.getMessage());
       	 	}



  //lectura del fichero****************************************************************



       	 try{
			File listaRecetas2 = new File("./receta.txt");
			FileInputStream fis = new FileInputStream(listaRecetas2);
	        InputStreamReader isr = new InputStreamReader(fis, "UTF8");
	        BufferedReader br = new BufferedReader(isr);



	        String linea;
	        linea = br.readLine();
	        String [] campos = null;
	        System.out.println("\nTus recetas...");
	        while(linea!=null){
	        	campos = linea.split(" ");
	        	System.out.println("--------------------------------");
	        	System.out.println("Nombre: "+campos[0]);
	       		System.out.println("Descripcion: "+campos[2]);
	       		String ingre = campos[1];
	       		campos = ingre.split("#");
	       		for(int x=0; x<campos.length; x++){
	       			String ingreAtribSeparados = campos[x];
	       			String [] campos2 = ingreAtribSeparados.split("\\*");
	       			System.out.println("Ingredientes: ");
	       			System.out.println("Nombre: "+campos2[0]);
	       			System.out.println("Gramos: "+campos2[1]);
	       			System.out.println("Unidades: "+campos2[2]);
	       			System.out.println("--------------------------------");
	       			//System.out.println("¿En gramos?: "+campos2[3]);
	       		}
	       		
	       		linea = br.readLine();
	        }
	        
	    }catch(Exception ioe){
	    	System.out.println("Error: "+ioe);
	    }
/*String nombrefichero2 = "receta.txt";	
			String ruta2 ="/home/zubiri/Proyectosjava/examen";
			
			
			//lectura del fichero censo.txt	
			File archivo2 = new File(ruta2, nombrefichero2);
			FileReader leer2 = new FileReader (archivo2);
			BufferedReader bf2 = new BufferedReader(leer2);
			String salida2 = bf2.readLine();

 			//creacion de arraylist para ir metiendo los datos del txt
			

		 do 
				{
					System.out.print(salida2);
				}while ((salida2 = bf2.readLine()) != null);

*/

        }
    }