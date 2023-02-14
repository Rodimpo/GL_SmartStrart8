package gl.patryk.kollek;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/registry")
@Slf4j
public class RegistryController {

    List<VehicleSO> vCollection = new ArrayList<>();

    @GetMapping("/get/{vin}")
    public VehicleSO get(@PathVariable(name = "vin") String vin)
    {
        VehicleSO v = new VehicleSO();
        v.setVin(vin);
        v.setModel("Arteon");
        v.setBrand("VW");
        v.setProductionYear(2022);
        log.info("Returning vehicle with vin: {}", vin);
        return v;
    }
    @PostMapping("/add")
    public String post(@RequestBody VehicleSO v)
    {
        vCollection.add(v);
        return "Vehicle added to list";
    }
    @DeleteMapping("/clear")
    public String clearData()
    {
        vCollection.clear();
        return "Vehicle list has been cleared!";
    }

}
