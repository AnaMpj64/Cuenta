
package states;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Count {
    static Scanner sc = new Scanner(System.in);
    static Map <String, Money> mapWord = new HashMap <>();
    public static void main(String[] args) {
        
        boolean salir = false;
		while (!salir)
		{
			System.out.println("\nMenu");
			System.out.println("1. Crear cuenta");
			System.out.println("2. Ver cuenta (Estado de cuenta)");
			System.out.println("3. Registrar Ingresos");
			System.out.println("4. Registrar Egresos");
			System.out.println("5. Cambiar tipo de cuenta");
                        System.out.println("6. Salir");
			
			String opcion=sc.next();
			switch (opcion) {
			
			case "1":
                            sc.nextLine();
			    crearCuenta();
                                break;
			case "2":
                                sc.nextLine();
			     verCuenta();
                            break;
			case "3":
                                sc.nextLine();
				registrarIngresos();
                            break;
			case "4":
                                sc.nextLine();
				registrarEgresos();
                            break;				
                        case "5":
                                sc.nextLine();
                                cambiarTipo();
                                System.out.println("\nEstimado usuario, le recordamos que: "
                                        + "\nLos valores de conversion son aproximados,"
                                        + "\npara un valor mas exacto"
                                        + "\nconsulte con su casa de cambio.");
                            break;
                        case "6":
                            salir = true;
                            break;
                       default:
                           System.out.println("Opcion invalida");
                           break;
			}
		}
    }
    
    public static void crearCuenta(){
        String cedula;
        System.out.println("Ingrese su cedula: ");
        cedula=sc.nextLine();
        if(verificarDatosSi(cedula)) {
        	System.out.println("Caracteres invalidos o extension erronea, ingrese su numero de cedula sin espacios");
        	return;
        }
        while(true){
        if(mapWord.containsKey(cedula)){
            System.out.println("Usuario ya registrado, ingrese uno nuevo");
            cedula =sc.nextLine();
        }else{
        String tipo="";
        String titular;
        System.out.println("\nSeleccione el tipo de cuenta (tipo de moneda)");
		System.out.println("1. Peso Colombiano");
		System.out.println("2. Peso Argentino");
		System.out.println("3. Peso Mexicano");
		System.out.println("4. Dolar");
                System.out.println("5. Euro");
			
		String opcion=sc.next();
		switch (opcion) {
			
		case "1":
                    sc.nextLine();
		    tipo="Peso(s) Colombiano(s)";
                    break;
		case "2":
                    sc.nextLine();
		    tipo="Peso(s) Argentino(s)";
                    break;
		case "3":
                    sc.nextLine();
            tipo="Peso(s) Mexicano(s)";
                    break;
		case "4":
                    sc.nextLine();
	        tipo="Dolare(s)";
                    break;
		case "5":
                    sc.nextLine();  
            tipo="Euro(s)";
                    break;
		default:
            System.out.println("Opcion invalida");
            break;
			}   
        System.out.println("Ingrese su nombre");
        titular=sc.nextLine();
        if(verificarNombreSi(titular)) {
        	System.out.println("Caracteres ilegales para un nombre, no sea mentiroso");
        	System.out.println("\nPrograma: *Existe... \nSebitas: 'Ni modo, toca introducir mal los datos' \nXD"); 
        	return;
        }        
        Money aux = new Money(tipo, titular);
        mapWord.put(cedula, aux);
        System.out.println("Cuenta creada exitosamente");
        break;
        }
       }
    }
    
    public static void verCuenta(){
        String cedula;
        System.out.println("Ingrese su cedula: ");
        cedula=sc.nextLine();
        if(verificarDatosSi(cedula)) {
        	System.out.println("Caracteres invalidos o extension erronea, ingrese su numero de cedula sin espacios");
        	return;
        }
        while(true){
        if(mapWord.containsKey(cedula)){
            var cuenta = mapWord.get(cedula);         
            System.out.println("\nCuenta del usuario de cedula: "+cedula);
            System.out.println(cuenta);
            if(cuenta.saldoTotal()<0) {
            	System.out.println("Usuario se encuentra con deuda vigente");
            }
            break;
        }else{
            System.out.println("Usuario no encontrado, ingrese nuevamente: ");
            cedula=sc.nextLine();
        }
    }
    }
    public static boolean verificarDatosSi(String cedula) {
    	for (int x = 0; x < cedula.length(); x++) {
            char c = cedula.charAt(x);
            if (((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return true;
            }
        }
    	if(cedula.length()==10) {
        return false;
    	}
    	return true;
    }
    public static boolean verificarNombreSi(String titular) {
    	return titular.matches(".*[0-9].*");
    }
      
    public static void registrarIngresos(){
        String cedula;
        System.out.println("Ingrese su cedula: ");
        cedula=sc.nextLine();
        if(verificarDatosSi(cedula)) {
        	System.out.println("Caracteres invalidos o extension erronea, ingrese su numero de cedula sin espacios");
        	return;
        }
        while(true){
        if(mapWord.containsKey(cedula)){
           var cuenta = mapWord.get(cedula); 
           System.out.println("Inserte sus ingresos: ");
           int ingresos = sc.nextInt(); 
           cuenta.registrarIngreso(ingresos);
           System.out.println("Ingresos registrados correctamente");
           break;
        }else{
            System.out.println("Usuario no encontrado, ingrese nuevamente: ");
            cedula=sc.nextLine();
        }
    }
    }
    public static void registrarEgresos(){
        String cedula;
        System.out.println("Ingrese su cedula: ");
        cedula=sc.nextLine();
        if(verificarDatosSi(cedula)) {
        	System.out.println("Caracteres invalidos o extension erronea, ingrese su numero de cedula sin espacios");
        	return;
        }
        while(true){
        if(mapWord.containsKey(cedula)){
           var cuenta = mapWord.get(cedula); 
           System.out.println("Inserte sus egresos: ");
           int egresos = sc.nextInt(); 
           cuenta.registrarEgreso(egresos);
           System.out.println("Egresos registrados correctamente");
           break;
        }else{
            System.out.println("Usuario no encontrado, ingrese nuevamente: ");
            cedula=sc.nextLine();
        }
    }
    }
     public static void cambiarTipo(){
        String cedula;
        System.out.println("Ingrese su cedula: ");
        cedula=sc.nextLine();
        if(verificarDatosSi(cedula)) {
        	System.out.println("Caracteres invalidos o extension erronea, ingrese su numero de cedula sin espacios");
        	return;
        }
        while(true){
        if(mapWord.containsKey(cedula)){
           var cuenta = mapWord.get(cedula); 
           System.out.println("\nSeleccione el tipo de moneda al que desea cambiar");
		System.out.println("1. Peso Colombiano");
		System.out.println("2. Peso Argentino");
		System.out.println("3. Peso Mexicano");
		System.out.println("4. Dolar");
                System.out.println("5. Euro");
			
		String opcion=sc.next();
		switch (opcion) {
			
		case "1":
                    sc.nextLine();
		     if(cuenta.getTipo().equals("Peso(s) Argentino(s)")){
                     cuenta.setIncomes(cuenta.getIncomes()*30);
                     cuenta.setOutflows(cuenta.getOutflows()*30);
                     cuenta.setSaldoTotal(cuenta.getSaldoTotal()*30);
                   } else if (cuenta.getTipo().equals("Peso(s) Colombiano(s)")){
                   System.out.println("La cuenta ya esta en pesos Colombianos");
                   } else if(cuenta.getTipo().equals("Dolare(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*3900);
                       cuenta.setOutflows(cuenta.getOutflows()*3900);
                       cuenta.setSaldoTotal(cuenta.saldoTotal()*3900);
                   } else if(cuenta.getTipo().equals("Euro(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*4200);
                       cuenta.setOutflows(cuenta.getOutflows()*4200);
                       cuenta.setSaldoTotal(cuenta.saldoTotal()*4200);
                   } else if(cuenta.getTipo().equals("Peso(s) Mexicano(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*200);
                       cuenta.setOutflows(cuenta.getOutflows()*200);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()*200);
                   }
                    cuenta.setTipo("Peso(s) Colombiano(s)");
                    System.out.println("Tipo de moneda cambiado a Pesos Colombianos");
                    break;
		case "2":
                    sc.nextLine();
		     if(cuenta.getTipo().equals("Peso(s) Argentino(s)")){
                     System.out.println("La cuenta ya esta en pesos Argentinos");
                   } else if (cuenta.getTipo().equals("Peso(s) Colombiano(s)")){
                     cuenta.setIncomes(cuenta.getIncomes()/33);
                     cuenta.setOutflows(cuenta.getOutflows()/33);
                     cuenta.setSaldoTotal(cuenta.getSaldoTotal()/33);
                   } else if(cuenta.getTipo().equals("Dolare(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*118);
                       cuenta.setOutflows(cuenta.getOutflows()*118);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()*118);
                   } else if(cuenta.getTipo().equals("Euro(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*126);
                       cuenta.setOutflows(cuenta.getOutflows()*126);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()*126);
                   } else if(cuenta.getTipo().equals("Peso(s) Mexicano(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*5);
                       cuenta.setOutflows(cuenta.getOutflows()*5);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()*5);
                   }
                    cuenta.setTipo("Peso(s) Argentino(s)");
                    System.out.println("Tipo de moneda cambiado a Pesos Argentinos");
                    break;
		case "3":
                    sc.nextLine();
                    if(cuenta.getTipo().equals("Peso(s) Argentino(s)")){
                    cuenta.setIncomes(cuenta.getIncomes()/5);
                    cuenta.setOutflows(cuenta.getOutflows()/5);
                    cuenta.setSaldoTotal(cuenta.getSaldoTotal()/5);
                   } else if (cuenta.getTipo().equals("Peso(s) Colombiano(s)")){
                     cuenta.setIncomes(cuenta.getIncomes()/199);
                     cuenta.setOutflows(cuenta.getOutflows()/199);
                     cuenta.setSaldoTotal(cuenta.getSaldoTotal()/199);
                   } else if(cuenta.getTipo().equals("Dolare(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*20);
                       cuenta.setOutflows(cuenta.getOutflows()*20);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()*20);
                   } else if(cuenta.getTipo().equals("Euro(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()*21);
                       cuenta.setOutflows(cuenta.getOutflows()*21);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()*21);
                   } else if(cuenta.getTipo().equals("Peso(s) Mexicano(s)")){
                       System.out.println("La cuenta ya esta en pesos Mexicanos");
                   }
                    cuenta.setTipo("Peso(s) Mexicano(s)");
                    System.out.println("Tipo de moneda cambiado a Pesos Mexicanos");
                    break;
		case "4":
                    sc.nextLine();
	            if(cuenta.getTipo().equals("Peso(s) Argentino(s)")){
                    cuenta.setIncomes(cuenta.getIncomes()/118);
                    cuenta.setOutflows(cuenta.getOutflows()/118);
                    cuenta.setSaldoTotal(cuenta.getSaldoTotal()/118);
                   } else if (cuenta.getTipo().equals("Peso(s) Colombiano(s)")){
                     cuenta.setIncomes(cuenta.getIncomes()/4000);
                     cuenta.setOutflows(cuenta.getOutflows()/4000);
                     cuenta.setSaldoTotal(cuenta.getSaldoTotal()/4000);
                   } else if(cuenta.getTipo().equals("Dolare(s)")){
                     System.out.println("La cuenta ya esta en Dolares");
                   } else if(cuenta.getTipo().equals("Euro(s)")){
                       cuenta.setIncomes((int) (cuenta.getIncomes()*1.07));
                       cuenta.setOutflows((int) (cuenta.getOutflows()*1.07));
                       cuenta.setSaldoTotal((int) (cuenta.getSaldoTotal()*1.07));
                   } else if(cuenta.getTipo().equals("Peso(s) Mexicano(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()/19);
                       cuenta.setOutflows(cuenta.getOutflows()/19);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()/19);
                   }
                    cuenta.setTipo("Dolare(s)");
                    System.out.println("Tipo de moneda cambiado a Dolares");
                    break;
		case "5":
                    sc.nextLine();  
                     if(cuenta.getTipo().equals("Peso(s) Argentino(s)")){
                    cuenta.setIncomes(cuenta.getIncomes()/126);
                    cuenta.setOutflows(cuenta.getOutflows()/126);
                    cuenta.setSaldoTotal(cuenta.getSaldoTotal()/126);
                   } else if (cuenta.getTipo().equals("Peso(s) Colombiano(s)")){
                     cuenta.setIncomes(cuenta.getIncomes()/4200);
                     cuenta.setOutflows(cuenta.getOutflows()/4200);
                     cuenta.setSaldoTotal(cuenta.getSaldoTotal()/4200);
                   } else if(cuenta.getTipo().equals("Dolare(s)")){
                     cuenta.setIncomes((int) (cuenta.getIncomes()/1.07));
                     cuenta.setOutflows((int) (cuenta.getOutflows()/1.07));
                     cuenta.setSaldoTotal((int) (cuenta.getSaldoTotal()/1.07));
                   } else if(cuenta.getTipo().equals("Euro(s)")){
                       System.out.println("La cuenta ya esta en Euros");                     
                   } else if(cuenta.getTipo().equals("Peso(s) Mexicano(s)")){
                       cuenta.setIncomes(cuenta.getIncomes()/21);
                       cuenta.setOutflows(cuenta.getOutflows()/21);
                       cuenta.setSaldoTotal(cuenta.getSaldoTotal()/21);
                   }
                    cuenta.setTipo("Euro(s)");
                    System.out.println("Tipo de moneda cambiado a Euros");                   
                    break;
		default:
            System.out.println("Opcion invalida");
            break;
			}          
            break;
        }else{
            System.out.println("Usuario no encontrado, ingrese nuevamente: ");
            cedula=sc.nextLine();
        }
     }
     }    
}
