package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Contribuyente;
import com.example.demo.service.ContribuyenteService;


@Controller
public class MainController {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	//inicio
	@RequestMapping ("/inicio")
	public ModelAndView Main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	
	//Mostrar lista de Estudiantes
	@RequestMapping ("/listado")
	public ModelAndView lista() {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyentes = null;
		try {
			contribuyentes = contribuyenteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("contribuyentes", contribuyentes);
		mav.setViewName("listado");
		return mav;
	}
	
	
	
	//un estudiante
	@RequestMapping (value = "/mostrarContribuyente", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam (value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Contribuyente contribuyente = contribuyenteService.findOne(id);
		
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("listado");
		return mav;
	}
	
	//save
	@RequestMapping ("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Contribuyente contribuyente, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("main");
		}
		else {
			contribuyenteService.save(contribuyente);
			List<Contribuyente> contribuyentes = null;
			try {
				contribuyentes = contribuyenteService.findAll();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("contribuyente", contribuyente);
			mav.setViewName("exito");
		}
		return mav;
	}
	
	//delete estudiante
	@RequestMapping (value = "/borrarContribuyente", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam (value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Contribuyente> contribuyente = null;
		try {
			contribuyenteService.delete(id);
			contribuyente = contribuyenteService.findAll();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("contribuyente", contribuyente);
		mav.setViewName("main");
		return mav;
	}
	
	@GetMapping("/insertarContribuyente")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("contribuyente", new Contribuyente());
		mav.setViewName("main");
		return mav;
	}
	

}
