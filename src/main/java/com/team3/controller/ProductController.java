package com.team3.controller;

import com.team3.dto.requests.CreateProductDTO;
import com.team3.dto.requests.UpdateProductDTO;
import com.team3.mappers.ProductMapper;
import com.team3.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/admin/product")
public class ProductController {

    IProductService productService;
    ProductMapper productMapper;

    @GetMapping
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "admin/product";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new CreateProductDTO());
        return "admin/product-new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("product") CreateProductDTO productDTO) {
        productService.create(productDTO);
        return "redirect:/admin/product";
    }

    @GetMapping("/update/{slug}")
    public String showUpdateForm(@PathVariable String slug, Model model) {
        model.addAttribute("productUpdate", productMapper.toUpdate(productService.findBySlug(slug)));
        return "admin/product-update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("productUpdate") UpdateProductDTO updateProductDTO) {
        productService.update(updateProductDTO);
        return "redirect:/admin/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/admin/product";
    }

}


