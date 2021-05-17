package com.ads.system.ads.controller;

import com.ads.system.ads.controller.dto.AdvertisingDto;
import com.ads.system.ads.controller.form.AdvertisingForm;
import com.ads.system.ads.model.Advertising;
import com.ads.system.ads.repository.AdvertisingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/ads")
public class AdvertisingController {

    @Autowired
    private AdvertisingRepository advertisingRepository;


    /**
     * Endpoint to list all ads
     *
     * @param client
     * @return list of ads
     */
    @GetMapping
    public List<AdvertisingDto> list (String client)  {
        if(client == null){
            List<Advertising> advertisings = advertisingRepository.findAll();
            return AdvertisingDto.converter(advertisings);

        }else {
            List<Advertising> advertisings = advertisingRepository.findByClient(client);
            return AdvertisingDto.converter(advertisings);

        }
    }

    /**
     * Endpoint to create a new ad
     *
     * @param advertisingForm
     * @param uriBuilder
     * @return the ad created
     */
    @PostMapping
    public ResponseEntity<AdvertisingDto> create(@RequestBody AdvertisingForm advertisingForm, UriComponentsBuilder uriBuilder) {
        Advertising advertising = advertisingForm.converter();
        advertisingRepository.save(advertising);

        URI uri = uriBuilder.path("/ads/{id}").buildAndExpand(advertising.getId()).toUri();
        return ResponseEntity.created(uri).body(new AdvertisingDto(advertising));
    }

    /**
     * Endpoint to calculate the total amount invested
     *
     * @param id advertising
     * @param days number of days filter
     * @return total amount investered
     */
    @GetMapping({"/invested/{id}","/invested/{id}/{days}"})
    public double totalInvested(@PathVariable Long id, @PathVariable(required = false) Integer days) {
        Optional<Advertising> advertising = advertisingRepository.findById(id);
        if(days == null){
            return advertising.get().totalInvested(0);

        }
        return advertising.get().totalInvested(days);
    }


    /**
     * Endpoint to calculate the number max of views the advertising
     *
     * @param id advertising
     * @param days number of days filter
     * @return max views
     */
    @GetMapping({"/views/{id}", "/views/{id}/{days}"})
    public int maxViews(@PathVariable Long id, @PathVariable(required = false) Integer days){
        Optional<Advertising> advertising = advertisingRepository.findById(id);
        if(days == null){
            return (int)advertising.get().maxViews(0);

        }
        return (int)advertising.get().maxViews(days);
    }

    /**
     * Endpoint to calculate the number max of clicks the advertising
     *
     * @param id advertising
     * @param days number of days filter
     * @return max clicks
     */
    @GetMapping({"/clicks/{id}","/clicks/{id}/{days}" })
    public int maxclick(@PathVariable Long id, @PathVariable(required = false) Integer days){
        Optional<Advertising> advertising = advertisingRepository.findById(id);
        if(days == null){
            return (int)advertising.get().maxClicks(0);
        }
        return (int)advertising.get().maxClicks(days);

    }


    /**
     * Endpoint to calculate the number max of share the advertising with period of days
     *
     * @param id advertising
     * @param days number of days to filter
     * @return max shares
     */
    @GetMapping({"/share/{id}","/share/{id}/{days}"})
    public int maxShare(@PathVariable Long id , @PathVariable(required = false) Integer days) {
        Optional<Advertising> advertising = advertisingRepository.findById(id);
        if(days == null){
            return (int)advertising.get().maxShare(0);
        }
        return (int)advertising.get().maxShare(days);

    }



}