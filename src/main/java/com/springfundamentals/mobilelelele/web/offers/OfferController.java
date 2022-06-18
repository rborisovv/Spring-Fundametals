package com.springfundamentals.mobilelelele.web.offers;

import com.springfundamentals.mobilelelele.bindingModel.OfferDto;
import com.springfundamentals.mobilelelele.service.BrandService;
import com.springfundamentals.mobilelelele.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;
    private final BrandService brandService;

    public OfferController(OfferService offerService, BrandService brandService) {
        this.offerService = offerService;
        this.brandService = brandService;
    }

    @ModelAttribute("offerModel")
    public OfferDto offerDto() {
        return new OfferDto();
    }

    @GetMapping("/all")
    public String allOffers(Model model) {
        model.addAttribute("offers", offerService.getAllOffers());
        return "offers";
    }

    @GetMapping("/add")
    public String addOfferPage(Model model) {
        model.addAttribute("brands", brandService.getAllBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid OfferDto offerModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("offerModel", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offerModel", bindingResult);
            return "redirect:/offers/add";
        }

        this.offerService.addOffer(offerModel);
        return "redirect:/offers/all";
    }
}