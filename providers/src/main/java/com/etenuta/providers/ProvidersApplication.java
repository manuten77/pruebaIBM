package com.etenuta.providers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProvidersApplication {
	 	 
	public static void main(String[] args) {
		if(args.length==0){
            System.out.println("You have to insert almost one int argument(client code)!");
            return;
        } 
        
        int codeClient=Integer.parseInt(args[0]);

        try {
           
        	final String bd="mydb"; 
            final String username="root";
            final String password="password";
            final String url="jdbc:mysql://localhost:3306/"+bd+"?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url, username, password);
            Statement stm=con.createStatement();
            ResultSet res=stm.executeQuery("SELECT id_proveedor, nombre, fecha_de_alta FROM proveedores where id_cliente="+codeClient);
            if(res.next()==false){
                System.out.println("No hay proveedores en la base de datos por este codigo cliente:"+codeClient);
                return;
            }
            //Result of arraylist providers
            ArrayList<Provider> listproviders = new ArrayList<Provider>();
           do {
                int id = res.getInt("id_proveedor");
                String name= res.getString("nombre");
                Date createDate= res.getDate("fecha_de_alta");
                listproviders.add(new Provider(id,name,createDate,codeClient));
            } while (res.next());

           String currentPath = new java.io.File("").getAbsolutePath(); 
           File file=new File(currentPath+"\\providers_"+codeClient+".txt");
           file.createNewFile();            
            FileWriter w;
            w=new FileWriter(file);
            BufferedWriter b;
            b=new BufferedWriter (w);
            Iterator<Provider> iter = listproviders.iterator();
            	while(iter.hasNext()) {
            		Provider prov=iter.next();
            		b.write(prov.toString());
                	b.write("\n"); 
                	System.out.println("Escribo proveedor con id:"+prov.getId()+" en el fichero txt.");
            	}
           b.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
		SpringApplication.run(ProvidersApplication.class, args);
	}

}
