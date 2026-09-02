package org.engyne;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import java.util.List;

@Controller("/devices")
public class DeviceController {


    final DeviceRepository deviceRepository;
    DeviceService  deviceService = new DeviceService();

    public DeviceController(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

//CRUD EndPoints design:

    @Get("/")
    @Produces(MediaType.APPLICATION_JSON)
    public String index() {
        return "Device Inventory Homepage"; // 4
    }

    @Get("/makes")
    List<String> listMake() {
        return this.deviceRepository.findMake(); // findMake() method is to be created in deviceRepository
    }

    @Get("/models")
    List<String> listModel() {
        return this.deviceRepository.findModel(); // findModel() method is to be created in deviceRepository
    }

    @Get("/list")
    List<DeviceDTO> list() {
        return this.deviceRepository.list(); // returns only make and year
    }

    @Post("/add")
    @Status(HttpStatus.OK)
    public HttpResponse<Device> addDevice(@Body Device device) {

        this.deviceRepository.save(device);
        return HttpResponse.status(HttpStatus.CREATED).body(device);
    }
    // curl -X POST http://localhost:8080/devices/add  -H "Content-Type: application/json" -d '{ "id": 7, "make":"arsta", "model":"7280R3", "os": "eos" , "year": 2023, "health": 2 }'

    @Put("/{id}/update")
    @Status(HttpStatus.OK)
    public HttpResponse<Device> updateDevice(Long id, @Body Device updatedDevice) {
           Device deviceExiting = deviceRepository.findById(id).orElseThrow(() -> new RuntimeException("Device is not found"));

        // Updating make field of existing device with user's:
             updatedDevice = deviceExiting.withMake(updatedDevice.getMake());
             // updatedDevice = deviceExiting.withMake(deviceService.generateText());
        //  Or updating model field of existing device with user's:
           //updatedDevice = deviceExiting.withModel(updatedDevice.getModel());

        // Updating repo:
            this.deviceRepository.update(updatedDevice);

        return HttpResponse.ok(updatedDevice);
    }

    // $ curl -X PUT "http://localhost:8080/devices/1/update"  -H "Content-Type: application/json" -d '{ "id": 1, "make":"CISCOx" }'


    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void deleteDevice(Long id) {
        this.deviceRepository.deleteById(id);
    }
    // $ curl -i -X DELETE http://localhost:8080/devices/1

}