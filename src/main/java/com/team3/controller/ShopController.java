package com.team3.controller;

import com.team3.entity.Product;
import com.team3.service.IProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/shop")
public class ShopController {

    IProductService productService;

    @GetMapping()
    public String shop(Model model,
                       @Param("keyword") String keyword,
                       @RequestParam(name = "pageNo", defaultValue = "1") int pageNo) {
        Page<Product> products = productService.getAll(keyword, pageNo);

        model.addAttribute("totalPage", products.getTotalPages());
        model.addAttribute("keyword", keyword);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("products", products);
        return "user/shop";
    }

    @GetMapping("/product-detail/{slug}")
    public String productDetails(@PathVariable String slug, Model model) {
        model.addAttribute("product", productService.findBySlug(slug));
        return "user/product-details";
    }
}
