package com.team3.controller;

import com.team3.dto.ProductDTO;
import com.team3.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/product")
public class ProductController {
    private final IProductService productService;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin/product";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("productDTO", new ProductDTO());
        model.addAttribute("isUpdating", false);
        return "admin/product-form";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("productDTO", productService.getById(id));
        model.addAttribute("isUpdating", true);
        return "admin/product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute("productDTO") ProductDTO productModel) {
        productService.save(productModel);
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/admin/product";
    }

}


