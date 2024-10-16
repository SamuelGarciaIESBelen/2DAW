package org.iesbelen.tiendainformatica.stream.test;

import java.util.*;

import org.iesbelen.tiendainformatica.entity.Fabricante;
import org.iesbelen.tiendainformatica.dao.FabricanteDAOImpl;
import org.iesbelen.tiendainformatica.entity.Producto;
import org.iesbelen.tiendainformatica.dao.ProductoDAOImpl;
import org.junit.jupiter.api.Test;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


class TiendaTest {

	private FabricanteDAOImpl fabricantesDAOImpl;
	private ProductoDAOImpl productosDAOImpl;


	public TiendaTest(){
		Fabricante fabricante;
		fabricantesDAOImpl = new FabricanteDAOImpl();
		productosDAOImpl = new ProductoDAOImpl();
		try {
			fabricantesDAOImpl.beginTransaction();
			productosDAOImpl.beginTransaction();

			// Creación de fabricantes y productos
			// Asus
			fabricante = new Fabricante("Asus");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"Monitor 27 LED Full HD",199.25));
			productosDAOImpl.create(new Producto(fabricante,"Monitor 24 LED Full HD",119.99));

			// Lenovo
			fabricante = new Fabricante("Lenovo");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"Portátil IdeaPad 320",359.65));
			productosDAOImpl.create(new Producto(fabricante,"Portátil Yoga 520",452.79));

			// Hewlett-Packard
			fabricante = new Fabricante("Hewlett-Packard");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"Impresora HP Deskjet 3720",59.99));
			productosDAOImpl.create(new Producto(fabricante,"Impresora HP Laserjet Pro M26nw",111.86));

			// Samsung
			fabricante = new Fabricante("Samsung");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"Disco SSD 1 TB",72.99));

			// Seagate
			fabricante = new Fabricante("Seagate");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"Disco duro SATA3 1TB",38.49));

			// Crucial
			fabricante = new Fabricante("Crucial");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"GeForce GTX 1080 Xtreme",611.55));
			productosDAOImpl.create(new Producto(fabricante,"Memoria RAM DDR4 8GB",24.19));

			// Gigabyte
			fabricante = new Fabricante("Gigabyte");
			fabricantesDAOImpl.create(fabricante);
			productosDAOImpl.create(new Producto(fabricante,"GeForce GTX 1050Ti",319.19));

			// Huawei sin productos a insertar
			fabricante = new Fabricante("Huawei");
			fabricantesDAOImpl.create(fabricante);

			// Xiaomi sin productos a insertar
			fabricante = new Fabricante("Xiaomi");
			fabricantesDAOImpl.create(fabricante);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
			fabricantesDAOImpl.rollbackTransaction();
			throw e; // or display error message
		}
	}
	
	@Test
	void testSkeletonFrabricante() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
		
			
			//TODO STREAMS
			

		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	

	@Test
	void testSkeletonProducto() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();		
						
			//TODO STREAMS

		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	@Test
	void testAllFabricante() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			assertEquals(9,listFab.size());
		
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	@Test
	void testAllProducto() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();		
			assertEquals(11,listProd.size());
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 1. Lista los nombres y los precios de todos los productos de la tabla producto
	 */
	@Test
	void test1() {

		try {
			productosDAOImpl.beginTransaction();
			
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.forEach(p-> System.out.println("Nombre: " + p.getNombre() + " || Precio: " + p.getPrecio()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 2. Devuelve una lista de Producto completa con el precio de euros convertido a dólares .
	 */
	@Test
	void test2() {

		try {
			productosDAOImpl.beginTransaction();			
			List<Producto> listProd = productosDAOImpl.findAll();
			List<Producto> dollars = listProd.stream()
					.map(p -> {
						p.setPrecio(p.getPrecio() * 1.10);
						return p;
					})
					.collect(toList());
			dollars.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 3. Lista los nombres y los precios de todos los productos, convirtiendo los nombres a mayúscula.
	 */
	@Test
	void test3() {
		
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			// listProd.forEach(p-> System.out.println("Nombre: " + p.getNombre().toUpperCase() + " || Precio: " + p.getPrecio()));
			listProd.stream()
					.map(prod -> "Nombre: " + prod.getNombre().toUpperCase() + " || Precio: " + prod.getPrecio())
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 4. Lista el nombre de todos los fabricantes y a continuación en mayúsculas los dos primeros caracteres del nombre del fabricante.
	 */
	@Test
	void test4() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.map(fab -> fab.getNombre() + " - " + fab.getNombre().substring(0, 2).toUpperCase())
					.forEach(System.out::println);

		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 5. Lista el código de los fabricantes que tienen productos.
	 */
	@Test
	void test5() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.filter(f -> !f.getProductos().isEmpty())
					.map(f -> f.getNombre() + " - " + f.getIdFabricante())
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 6. Lista los nombres de los fabricantes ordenados de forma descendente.
	 */
	@Test
	void test6() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.sorted(comparing(Fabricante::getNombre).reversed())
					.forEach(p -> System.out.println(p.getNombre()));
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 7. Lista los nombres de los productosDAOImpl ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
	 */
	@Test
	void test7() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.sorted(Comparator
						.comparing(Producto::getNombre)
						.thenComparing(Comparator.comparing(Producto::getPrecio).reversed())
					)
					.forEach(p -> System.out.println(p.getNombre() + " - " + p.getPrecio()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 8. Devuelve una lista con los 5 primeros fabricantes.
	 */
	@Test
	void test8() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.limit(5)
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 9.Devuelve una lista con 2 fabricantes a partir del cuarto fabricante. El cuarto fabricante también se debe incluir en la respuesta.
	 */
	@Test
	void test9() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.skip(3)
					.limit(2)
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 10. Lista el nombre y el precio del producto más barato
	 */
	@Test
	void test10() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.min(comparing(Producto::getPrecio))
					.ifPresent(p -> System.out.println(p.getNombre() + " - " + p.getPrecio()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 11. Lista el nombre y el precio del producto más caro
	 */
	@Test
	void test11() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.max(comparing(Producto::getPrecio))
							.ifPresent(p -> System.out.println(p.getNombre() + " - " + p.getPrecio()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 12. Lista el nombre de todos los productos del fabricante cuyo código de fabricante es igual a 2.
	 */
	@Test
	void test12() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.filter(p -> p.getFabricante().getIdFabricante() == 2)
					.forEach(p -> System.out.println(p.getNombre()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 13. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
	 */
	@Test
	void test13() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.filter(p -> p.getPrecio() <= 120)
					.forEach(p -> System.out.println(p.getNombre()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 14. Lista los productos que tienen un precio mayor o igual a 400€.
	 */
	@Test
	void test14() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.filter(p -> p.getPrecio() >= 400)
					.forEach(p -> System.out.println(p.getNombre()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 15. Lista todos los productos que tengan un precio entre 80€ y 300€.
	 */
	@Test
	void test15() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.filter(p -> p.getPrecio() <= 80 || p.getPrecio() >= 300)
					.forEach(p -> System.out.println(p.getNombre()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 16. Lista todos los productos que tengan un precio mayor que 200€ y que el código de fabricante sea igual a 6.
	 */
	@Test
	void test16() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.filter(p -> p.getPrecio() > 200)
					.filter(p -> p.getFabricante().getIdFabricante() == 6)
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 17. Lista todos los productos donde el código de fabricante sea 1, 3 o 5 utilizando un Set de codigos de fabricantes para filtrar.
	 */
	@Test
	void test17() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			Set<Integer> codigosFab = Set.of(1, 3, 5);

			listProd.stream()
					.filter(p -> codigosFab.contains(p.getFabricante().getIdFabricante()))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 18. Lista el nombre y el precio de los productos en céntimos.
	 */
	@Test
	void test18() {

		try {
			productosDAOImpl.beginTransaction();

			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.map(p -> p.getNombre() + " " + p.getPrecio() * 100 + " cts")
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 19. Lista los nombres de los fabricante cuyo nombre empiece por la letra S
	 */
	@Test
	void test19() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.filter(f -> 'S' == f.getNombre().toUpperCase().charAt(0))
					.forEach(f -> System.out.println(f.getNombre()));
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
		
	}
	
	/**
	 * 20. Devuelve una lista con los productos que contienen la cadena Portátil en el nombre.
	 */
	@Test
	void test20() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			List<Producto> portatiles = listProd.stream()
										.filter(p -> p.getNombre().contains("Portátil"))
										.collect(toList());
			portatiles.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 21. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
	 */
	@Test
	void test21() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			List<String> monitores = listProd.stream()
												.filter(p -> p.getNombre().contains("Monitor") && p.getPrecio() < 215)
												.map(Producto::getNombre)
												.collect(toList());
			monitores.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 22. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€.
	 * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
	 */
	@Test
	void test22() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.filter(p -> p.getPrecio() >= 180)
					.sorted(comparing(Producto::getPrecio).reversed()
						.thenComparing(Producto::getNombre))
					.forEach(p -> System.out.println(p.getNombre() + " - " + p.getPrecio()));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 23. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
	 * Ordene el resultado por el nombre del fabricante, por orden alfabético.
	 */
	@Test
	void test23() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			List<String> productosFab = listProd.stream()
					.sorted((a, b) -> a.getFabricante().getNombre().compareToIgnoreCase(b.getFabricante().getNombre()))
					.map(p -> ("Nombre: " + p.getNombre()) + " - Precio: " + p.getPrecio() + " - Fabricante: " + p.getFabricante().getNombre())
					.collect(toList());
			productosFab.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 24. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
	 */
	@Test
	void test24() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			String prodMasCaro = listProd.stream()
					.max(Comparator.comparing(Producto::getPrecio))
					.map(p -> ("Nombre: " + p.getNombre()) + " - Precio: " + p.getPrecio() + " - Fabricante: " + p.getFabricante().getNombre())
					.toString();
			System.out.println(prodMasCaro);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 25. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
	 */
	@Test
	void test25() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			List<Producto> crucial = listProd.stream()
					.filter(p -> "Crucial".equals(p.getFabricante().getNombre()) && p.getPrecio() > 200)
					.collect(toList());
			crucial.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 26. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate
	 */
	@Test
	void test26() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			List<Producto> asusHewlettSeagate = listProd.stream()
					.filter(p -> "Asus".equals(p.getFabricante().getNombre())
							|| "Hewlett-Packard".equals(p.getFabricante().getNombre())
							|| "Seagate".equals(p.getFabricante().getNombre()))
					.collect(toList());
			asusHewlettSeagate.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 27. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180€.
	 * Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre.
	 * El listado debe mostrarse en formato tabla. Para ello, procesa las longitudes máximas de los diferentes campos a presentar y compensa mediante la inclusión de espacios en blanco.
	 * La salida debe quedar tabulada como sigue:

Producto                Precio             Fabricante
-----------------------------------------------------
GeForce GTX 1080 Xtreme|611.5500000000001 |Crucial
Portátil Yoga 520      |452.79            |Lenovo
Portátil Ideapd 320    |359.64000000000004|Lenovo
Monitor 27 LED Full HD |199.25190000000003|Asus

	 */		
	@Test
	void test27() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();

			//TODO STREAMS

		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 28. Devuelve un listado de los nombres fabricantes que existen en la base de datos, junto con los nombres productos que tiene cada uno de ellos.
	 * El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
	 * SÓLO SE PUEDEN UTILIZAR STREAM, NO PUEDE HABER BUCLES
	 * La salida debe queda como sigue:
Fabricante: Asus

            	Productos:
            	Monitor 27 LED Full HD
            	Monitor 24 LED Full HD

Fabricante: Lenovo

            	Productos:
            	Portátil Ideapd 320
            	Portátil Yoga 520

Fabricante: Hewlett-Packard

            	Productos:
            	Impresora HP Deskjet 3720
            	Impresora HP Laserjet Pro M26nw

Fabricante: Samsung

            	Productos:
            	Disco SSD 1 TB

Fabricante: Seagate

            	Productos:
            	Disco duro SATA3 1TB

Fabricante: Crucial

            	Productos:
            	GeForce GTX 1080 Xtreme
            	Memoria RAM DDR4 8GB

Fabricante: Gigabyte

            	Productos:
            	GeForce GTX 1050Ti

Fabricante: Huawei

            	Productos:


Fabricante: Xiaomi

            	Productos:

	 */
	@Test
	void test28() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.map(fab-> "Fabricante: " + fab.getNombre() + "\n\t Productos:\n" + fab.getProductos().stream()
							.map(p-> "\t\t" + p.getNombre())
							.collect(joining("\n")) + "\n")
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 29. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
	 */
	@Test
	void test29() {

		try {
			fabricantesDAOImpl.beginTransaction();
	
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			List<Fabricante> sinProductos = listFab.stream()
					.filter(p -> p.getProductos().isEmpty() )
					.collect(toList());
			sinProductos.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 30. Calcula el número total de productos que hay en la tabla productos. Utiliza la api de stream.
	 */
	@Test
	void test30() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			System.out.println("Hay un total de " + listProd.stream().count() + " productos");
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 31. Calcula el número de fabricantes con productos, utilizando un stream de Productos.
	 */
	@Test
	void test31() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			int fabricantes = (int)listProd.stream()
					.map(Producto::getFabricante)
					.distinct()
					.count();
			System.out.println("Hay un total de " + fabricantes + " fabricantes con productos");
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 32. Calcula la media del precio de todos los productos
	 */
	@Test
	void test32() {
	
		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			OptionalDouble media = listProd.stream()
					.mapToDouble(Producto::getPrecio)
					.average();
			media.ifPresent(p -> System.out.println("El precio medio es de " + p + "€"));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 33. Calcula el precio más barato de todos los productos. No se puede utilizar ordenación de stream.
	 */
	@Test
	void test33() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			listProd.stream()
					.mapToDouble(Producto::getPrecio)
					.min()
					.ifPresent(p -> System.out.println("El producto más barato vale " + p + "€"));
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 34. Calcula la suma de los precios de todos los productos.
	 */
	@Test
	void test34() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			/*
			System.out.println(listProd.stream()
					.mapToDouble(Producto::getPrecio)
					.sum());
			*/
			listProd.stream()
					.map(Producto::getPrecio)
					.reduce((acc, cur) -> acc + cur)
					.ifPresent(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 35. Calcula el número de productos que tiene el fabricante Asus.
	 */
	@Test
	void test35() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			System.out.println("Asus tiene " +
					listProd.stream()
					.filter(p -> "Asus".equals(p.getFabricante().getNombre()))
					.count() + " productos");
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 36. Calcula la media del precio de todos los productos del fabricante Asus.
	 */
	@Test
	void test36() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();
			System.out.print("El precio medio es ");
			listProd.stream()
					.filter(p -> "Asus".equals(p.getFabricante().getNombre()))
					.mapToDouble(Producto::getPrecio)
					.average()
					.ifPresent(System.out::println);
		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}

	/**
	 * 37. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos que tiene el fabricante Crucial.
	 *  Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 */
	@Test
	void test37() {

		try {
			productosDAOImpl.beginTransaction();
		
			List<Producto> listProd = productosDAOImpl.findAll();

			//TODO STREAMS

		}
		catch (RuntimeException e) {
			productosDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 38. Muestra el número total de productos que tiene cada uno de los fabricantes.
	 * El listado también debe incluir los fabricantes que no tienen ningún producto. 
	 * El resultado mostrará dos columnas, una con el nombre del fabricante y otra con el número de productos que tiene.
	 * Ordene el resultado descendentemente por el número de productos. Utiliza String.format para la alineación de los nombres y las cantidades.
	 * La salida debe queda como sigue:
	 
     Fabricante     #Productos
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
           Asus              2
         Lenovo              2
Hewlett-Packard              2
        Samsung              1
        Seagate              1
        Crucial              2
       Gigabyte              1
         Huawei              0
         Xiaomi              0
	 */
	@Test
	void test38() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			System.out.println(String.format("%-20s %-10s", "Fabricante", "#Productos"));
			System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			listFab.stream()
					.map(fab -> String.format("%-20s %-10s", fab.getNombre(), fab.getProductos().size()))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 39. Muestra el precio máximo, precio mínimo y precio medio de los productos de cada uno de los fabricantes.
	 * El resultado mostrará el nombre del fabricante junto con los datos que se solicitan. Realízalo en 1 solo stream principal. Utiliza reduce con Double[] como "acumulador".
	 * Deben aparecer los fabricantes que no tienen productosDAOImpl.
	 */
	@Test
	void test39() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.map(f -> {
						DoubleSummaryStatistics stats = f.getProductos().stream().mapToDouble(Producto::getPrecio).summaryStatistics();
						String cadena = "";
						if (stats.getCount() != 0) {
							cadena = f.getNombre() + " - Precio mínimo: " + stats.getMin() + " - Precio medio: " + stats.getAverage() + " - Precio máximo: " + stats.getMax();
						} else {
							cadena = f.getNombre() + " - No hay productos";
						}
						return cadena;
					})
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 40. Muestra el precio máximo, precio mínimo, precio medio y el número total de productos de los fabricantes que tienen un precio medio superior a 200€.
	 * No es necesario mostrar el nombre del fabricante, con el código del fabricante es suficiente.
	 */
	@Test
	void test40() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.filter(f -> f.getProductos().stream().mapToDouble(Producto::getPrecio).average().orElse(0) > 200)
					.map(f -> {
						DoubleSummaryStatistics stats = f.getProductos().stream().collect(summarizingDouble(Producto::getPrecio));
						return f.getIdFabricante() + " Stats: " + stats;
					}).forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 41. Devuelve un listado con los nombres de los fabricantes que tienen 2 o más productos.
	 */
	@Test
	void test41() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.filter(f -> f.getProductos().size() >= 2)
					.map(Fabricante::getNombre)
					.collect(toList())
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 42. Devuelve un listado con los nombres de los fabricantes y el número de productos que tiene cada uno con un precio superior o igual a 220 €.
	 * Ordenado de mayor a menor número de productos.
	 */
	@Test
	void test42() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.map(f -> f.getNombre() + "\t" + f.getProductos().stream().filter(p -> p.getPrecio() >= 220).count())
					.sorted((a, b) -> b.split("\t")[1].compareTo(a.split("\t")[1]))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 43.Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 */
	@Test
	void test43() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.filter(f -> f.getProductos().stream().mapToDouble(Producto::getPrecio).sum() > 1000) // No hay ninguno, bajar para comprobar
					.map(Fabricante::getNombre)
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 44. Devuelve un listado con los nombres de los fabricantes donde la suma del precio de todos sus productos es superior a 1000 €
	 * Ordenado de menor a mayor por cuantía de precio de los productos.
	 */
	@Test
	void test44() {

		try {
			fabricantesDAOImpl.beginTransaction();
				
			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.filter(f -> f.getProductos().stream().mapToDouble(Producto::getPrecio).sum() > 1000) // No hay ninguno, bajar para comprobar
					.map(f -> f.getNombre() + "\t" + f.getProductos().stream().mapToDouble(Producto::getPrecio).sum())
					.sorted((a, b) -> a.split("\t")[1].compareTo(b.split("\t")[1]))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
	
	/**
	 * 45. Devuelve un listado con el nombre del producto más caro que tiene cada fabricante. 
	 * El resultado debe tener tres columnas: nombre del producto, precio y nombre del fabricante. 
	 * El resultado tiene que estar ordenado alfabéticamente de menor a mayor por el nombre del fabricante.
	 */
	@Test
	void test45() {

		try {
			fabricantesDAOImpl.beginTransaction();

			List<Fabricante> listFab = fabricantesDAOImpl.findAll();
			listFab.stream()
					.map(fab-> fab.getProductos().stream()
							.max(Comparator.comparing(Producto::getPrecio))
							.map(p-> "Producto:\t" + p.getNombre() + "\t" + p.getPrecio()
									+ " | Fabricante:\t" + p.getFabricante().getNombre())
									.orElse(" | Fabricante:\t " + fab.getNombre() + " (sin productos)"))
					.sorted((a,b)->a.split("Fabricante:\t")[1].compareTo(b.split("Fabricante:\t")[1]))
					.forEach(System.out::println);
		}
		catch (RuntimeException e) {
			fabricantesDAOImpl.rollbackTransaction();
		    throw e; // or display error message
		}
	}
}

