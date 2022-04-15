package cl.icap.proyectofinal.m5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.icap.proyectofinal.m5.entity.Estado;
import cl.icap.proyectofinal.m5.entity.Rol;
import cl.icap.proyectofinal.m5.entity.Ticket;
import cl.icap.proyectofinal.m5.entity.Usuario;
import cl.icap.proyectofinal.m5.service.EstadoService;
import cl.icap.proyectofinal.m5.service.RolService;
import cl.icap.proyectofinal.m5.service.TicketService;
import cl.icap.proyectofinal.m5.service.UsuarioService;



@Controller
public class AppController {

	@Autowired
	private EstadoService estadoservice;
	
	@Autowired
	private UsuarioService usuariosservice;
	
	@Autowired
	private RolService rolservice;
	
	@Autowired
	private TicketService ticketservice;



	@RequestMapping("/")
	public String defectDetails0() {
		return "index";
	}

	@RequestMapping("/newEstado")
	public String showNewProductPage(Model model) {
		Estado estados = new Estado();
		model.addAttribute("estados", estados);

		return "newEstado";

	}

	@RequestMapping(value = "/saveEstado", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("estados") Estado estados) {
		estadoservice.save(estados);

		return "redirect:/EstadosSistemaCRUD";
	}

	@RequestMapping("/home")
	public String defectDetails() {
		return "home";
	}


	@RequestMapping("/mistickets")
	public String defectDetails1() {
		return "mistickets";
	}


	@RequestMapping("/EstadosSistemaCRUD")
	public String defectDetails4(Model model) {
		List<Estado> listEstados = estadoservice.listAll();
		model.addAttribute("listEstados", listEstados);
		return "EstadosSistemaCRUD";
	}

	@RequestMapping("/editEstado/{idestado}")
	public ModelAndView showEditProductPage(@PathVariable(name = "idestado") String idestado) {
		ModelAndView mav = new ModelAndView("editEstado");
		Estado estados = estadoservice.get(idestado);
		mav.addObject("estados", estados);

		return mav;
	}

	@RequestMapping("/deleteEstado/{idestado}")
	public String deleteProduct(@PathVariable(name = "idestado") String idestado) {
		estadoservice.delete(idestado);
		return "redirect:/EstadosSistemaCRUD";
	}
	
	@RequestMapping("/UsuarioCRUD")
	public String defectDetails5(Model model3) {
		List<Usuario> listUsuarios= usuariosservice.listAll();
		model3.addAttribute("listUsuarios", listUsuarios);
		return "UsuarioCRUD";
	}
	
	@RequestMapping("/newUsuario")
	public String showNewProductPage1(Model model) {
		Usuario usuarios= new Usuario();
		model.addAttribute("usuarios", usuarios);

		return "newUsuario";

	}
	
	@RequestMapping(value = "/saveUsuario", method = RequestMethod.POST)
	public String saveProduct1(@ModelAttribute("usuarios") Usuario usuarios) {
		usuariosservice.save(usuarios);

		return "redirect:/UsuarioCRUD";
	}
	
	@RequestMapping("/editUsuario/{IdUsuario}")
	public ModelAndView showEditProductPage1(@PathVariable(name = "IdUsuario") String IdUsuario) {
		ModelAndView mav = new ModelAndView("editUsuario");
		Usuario usuarios = usuariosservice.get(IdUsuario);
		mav.addObject("usuarios", usuarios);
		
		return mav;
	}
	
	@RequestMapping("/deleteUsuario/{IdUsuario}")
	public String deleteProduct1(@PathVariable(name = "IdUsuario") String idUsuario) {
		usuariosservice.delete(idUsuario);
		return "redirect:/UsuarioCRUD";
	}
	
	

	@RequestMapping("/RolCRUD")
	public String defectDetails6(Model model2) {
		List<Rol> listRol= rolservice.listAll();
		model2.addAttribute("listRol", listRol);
		return "RolCRUD";
	}
	
	@RequestMapping("/newRol")
	public String showNewProductPage11(Model model) {
		Rol rol = new Rol();
		model.addAttribute("rol", rol);

		return "newRol";
	}
	
	@RequestMapping(value = "/saveRol", method = RequestMethod.POST)
	public String saveProduct11(@ModelAttribute("rol") Rol rol) {
		rolservice.save(rol);

		return "redirect:/RolCRUD";
	}
	
	@RequestMapping("/editRol/{Idrol}")
	public ModelAndView showEditProductPage11(@PathVariable(name = "Idrol") String Idrol) {
		ModelAndView mav = new ModelAndView("editRol");
		Rol rol = rolservice.get(Idrol);
		mav.addObject("rol", rol);
		
		return mav;
	}
	
	@RequestMapping("/deleteRol/{Idrol}")
	public String deleteProduct11(@PathVariable(name = "Idrol") String idrol) {
		rolservice.delete(idrol);
		return "redirect:/RolCRUD";
	}
	
	@RequestMapping("/creaticket")
	public String showNewProductPage111(Model model) {
		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);

		return "creaticket";
	}
	
	@RequestMapping(value = "/saveTicket", method = RequestMethod.POST)
	public String saveProduct1(@ModelAttribute("ticket") Ticket ticket) {
		ticketservice.save(ticket);

		return "redirect:/home";
	}
	

	

}
