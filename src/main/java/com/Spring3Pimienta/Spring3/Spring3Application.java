package com.Spring3Pimienta.Spring3;

import com.Spring3Pimienta.Spring3.entities.*;
import com.Spring3Pimienta.Spring3.enums.EstadoPedido;
import com.Spring3Pimienta.Spring3.enums.FormaPago;
import com.Spring3Pimienta.Spring3.enums.TipoEnvio;
import com.Spring3Pimienta.Spring3.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Spring3Application {
	@Autowired
	CategoriaProductoRepository categoriaProductoRepository;
	@Autowired
	IngredienteRepository ingredienteRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetalleProductoRepository detalleProductoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroIngredienteRepository rubroIngrdienteRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring3Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean //HACER modificaciones cuando hagan los cambios en el modelo de clases
	public CommandLineRunner init(CategoriaProductoRepository categoriaProductoRepo, IngredienteRepository ingredienteRepo, ProductoRepository productoRepo,
								  ClienteRepository clienteRepo, DetalleProductoRepository detalleProductoRepo,
								  DetalleFacturaRepository detalleFacturaRepo, DetallePedidoRepository detallePedidoRepo,
								  DomicilioRepository domicilioRepo, FacturaRepository facturaRepo, PedidoRepository pedidoRepo,
								  RubroIngredienteRepository rubroIngredienteRepo, UnidadMedidaRepository unidadMedidaRepo,
								  UsuarioRepository usuarioRepo) {
		System.out.println("-----------------ESTOY FUNCIONANDO---------");
		return args -> {

			//Le doy formato a Date
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha1 = "2023-09-10";
			String fecha2 = "2023-08-15T";
			String fecha3 = "2023-07-03T";

			//Parseo String en un objeto Date
			Date fechaUno = formatoFecha.parse(fecha1);
			Date fechaDos = formatoFecha.parse(fecha2);
			Date fechaTres = formatoFecha.parse(fecha3);

			//Formato Date para horaEstimadaFinalizacion
			SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm:ss");
			String horario1 = "21:42:05";
			String horario2 = "23:00:58";
			String horario3 = "23:28:32";

			//Parseo String en un objeto Date
			Date horarioUno = formatoFecha.parse(fecha1);
			Date horarioDos = formatoFecha.parse(fecha2);
			Date horarioTres = formatoFecha.parse(fecha3);

			// Crear Clientes
			Cliente cliente1 = Cliente.builder()
					.nombre("Rodrigo")
					.apellido("Viluron")
					.telefono("2617869567")
					.email("rodri@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Roberto")
					.apellido("Marin")
					.telefono("764467375")
					.email("roberto@gmail.com")
					.build();

			// Guardar Clientes
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			// Crear Domicilios
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle falsa")
					.numero(123)
					.codigoPostal(5507)
					.localidad("Luján de Cuyo")
					.numeroDpto(1)
					.pisoDpto(1)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Callejón falso")
					.numero(456)
					.codigoPostal(5501)
					.localidad("Godoy Cruz")
					.build();

			// Asignar Domicilio a Cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente2.agregarDomicilio(domicilio2);

			// Guardar Domicilio
			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			// Guardar Clientes
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			// Crear Usuario
			Usuario usuario1 = Usuario.builder()
					.auth0Id("1")
					.username("rodri@gmail.com")
					.build();

			Usuario usuario2 = Usuario.builder()
					.auth0Id("2")
					.username("roberto@gmail.com")
					.build();


			// Agregar usuarios a los clientes
			cliente1.setUsuario(usuario1);
			cliente2.setUsuario(usuario2);

			// Crear UnidadMedida
			UnidadMedida unidadMedida1 = UnidadMedida.builder()
					.denominacion("kilos")
					.abreviatura("kg")
					.build();

			// Crear Rubro
			RubroIngrediente rubro1 = RubroIngrediente.builder()
					.denominacion("vegetales")
					.build();

			// Crear Ingredientes
			Ingrediente ingrediente1 = Ingrediente.builder()
					.denominacion("tomate")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenTomate")
					.build();

			Ingrediente ingrediente2 = Ingrediente.builder()
					.denominacion("carne")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenCarne")
					.build();

			// Asignar UnidadMedida a Ingrediente
			ingrediente1.setUnidadMedida(unidadMedida1);

			// Asignar Ingrediente a Rubro
			rubro1.agregarIngrediente(ingrediente1);



			// Crear Categoría de Productos
			CategoriaProducto categoriaProducto1 = CategoriaProducto.builder()
					.denominacion("Hamburguesas")
					.build();

			CategoriaProducto categoriaProducto2 = CategoriaProducto.builder()
					.denominacion("Lomos")
					.build();

			// Guardar Categoría de Productos
			categoriaProductoRepository.save(categoriaProducto1);
			categoriaProductoRepository.save(categoriaProducto2);

			// Crear Productos
			Producto producto1 = Producto.builder()
					.denominacion("Hamburguesa_clásica")
					.descripcion("Carne, pan, lechuga, tomate, queso.")
					.tiempoEstimadoCocina(20)
					.precioVenta(4000.00)
					.precioCosto(1500.00)
					.urlImagen("urlImagenHamburguesaClásica")
					.build();

			Producto producto2 = Producto.builder()
					.denominacion("Lomo_clásico")
					.descripcion("Cocinado a la parrilla y sazonado al gusto, servido con acompañamientos como papas fritas o ensalada.")
					.tiempoEstimadoCocina(25)
					.precioVenta(4500.00)
					.precioCosto(2000.00)
					.urlImagen("urlImagenLomoClásico")
					.build();

			// Asignar Producto a Categoría de Productos
			categoriaProducto1.agregarProducto(producto1);
			categoriaProducto2.agregarProducto(producto2);

			// Guardar Productos
			productoRepository.save(producto1);
			productoRepository.save(producto2);
			// Crear DetalleProducto
			DetalleProducto detalleProducto1 = DetalleProducto.builder()
					.cantidad(5)
					.build();

			DetalleProducto detalleProducto2 = DetalleProducto.builder()
					.cantidad(4)
					.build();

			// Asignar Ingredientes a DetalleProducto
			detalleProducto1.setIngrediente(ingrediente1);
			detalleProducto2.setIngrediente(ingrediente2);

			// Asignar DetalleProducto a Producto
			producto1.agregarDetalleProducto(detalleProducto1);
			producto1.agregarDetalleProducto(detalleProducto2);

			// Guardar DetalleProducto
			detalleProductoRepository.save(detalleProducto1);
			detalleProductoRepository.save(detalleProducto2);

			// Crear Pedido
			Pedido pedido1 = Pedido.builder()
					.fechaPedido(fechaUno)
					.horaEstimadaFinalizacion(horarioUno)
					.totalPedido(8500)
					.totalCosto(3000.00)
					.estadoPedido(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.formaPago(FormaPago.EFECTIVO)
					.build();

			Pedido pedido2 = Pedido.builder()
					.fechaPedido(fechaDos)
					.horaEstimadaFinalizacion(horarioDos)
					.totalPedido(8500)
					.totalCosto(3000.00)
					.estadoPedido(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.formaPago(FormaPago.EFECTIVO)
					.build();

			// Asignar Usuario a Pedido
			//pedido1.setUsuario(usuario1);
			//pedido2.setUsuario(usuario1);

			// Guardar Pedido
			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);

			// Crear Factura
			Factura factura1 = Factura.builder()
					.fechaFacturacion(fechaUno)
					.numeroFactura(1)
					.porcentajeDescuento(10.00)
					.formaPago(FormaPago.EFECTIVO)
					.totalCosto(3000.00)
					.totalVenta(8500.00)
					.build();

			Factura factura2 = Factura.builder()
					.fechaFacturacion(fechaUno)
					.numeroFactura(2)
					.porcentajeDescuento(0.0)
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalCosto(4000.00)
					.totalVenta(9500.00)
					.build();

			// Asignar Factura a Pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			// Guardar Factura
			facturaRepository.save(factura1);
			facturaRepository.save(factura2);

			// Crear DetalleFactura
			DetalleFactura detalleFactura1 = DetalleFactura.builder()
					.cantidad(2)
					.build();

			DetalleFactura detalleFactura2 = DetalleFactura.builder()
					.cantidad(3)
					.build();

			DetalleFactura detalleFactura3 = DetalleFactura.builder()
					.cantidad(1)
					.build();

// Asignar Ingrediente a DetalleFactura
		//	detalleFactura1.setIngrediente(ingrediente1);
		//	detalleFactura2.setIngrediente(ingrediente2);

// Asignar Producto a DetalleFactura
			detalleFactura1.setProducto(producto1);
			detalleFactura2.setProducto(producto1);
			detalleFactura3.setProducto(producto2);

// Guardar DetalleFactura
			detalleFacturaRepository.save(detalleFactura1);
			detalleFacturaRepository.save(detalleFactura2);
			detalleFacturaRepository.save(detalleFactura3);




			//-----------------------------------------------------------------------------------
			//Uso de Métodos

			//recuperar Cliente desde BD
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				System.out.println("Teléfono: " + clienteRecuperado.getTelefono());
				clienteRecuperado.mostrarDomicilios();
				System.out.println("----------------------------------------");
			}

			Producto productoRecuperado = productoRepository.findById(producto1.getId()).orElse(null);
			if (productoRecuperado != null) {
				System.out.println("-------------------------------------------------------");
				System.out.println("Denominacion: " + productoRecuperado.getDenominacion());
				System.out.println("Tiempo Estimado Cocina: " + productoRecuperado.getTiempoEstimadoCocina());
				System.out.println("Precio Venta: " + productoRecuperado.getPrecioVenta());
				System.out.println("Precio Costo: " + productoRecuperado.getPrecioCosto());
				productoRecuperado.mostrarDetalleProducto();
			}




		};

	}

}



