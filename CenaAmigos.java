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
             for(int y=0; y<recetas.size(); y++)
        		{
            	bw.write(ingredientess.get(y).getNombreIngrediente() + "*");
             	bw.write(ingredientess.get(y).getCantidadGramos() + "*");
             	bw.write(ingredientess.get(y).getCantidadUnidad() + "*");
             	bw.write(ingredientess.get(y).getEnGramos() + "#");


            
        }	
              bw.write(recetas.get(r).getPreparacion() + ";");

            
        }	
			









        	bw.close();
        }
        catch (FileNotFoundException e) 
			{
           			 System.out.println(e.getMessage());
       	 	}



  //lectura del fichero****************************************************************

String nombrefichero2 = "receta.txt";	
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



        }
    }