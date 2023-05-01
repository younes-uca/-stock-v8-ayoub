package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.Vente;
import ma.sir.easystock.bean.history.VenteHistory;
import ma.sir.easystock.dao.criteria.core.VenteCriteria;
import ma.sir.easystock.dao.criteria.history.VenteHistoryCriteria;
import ma.sir.easystock.service.facade.admin.VenteAdminService;
import ma.sir.easystock.ws.converter.VenteConverter;
import ma.sir.easystock.ws.dto.VenteDto;
import ma.sir.easystock.zynerator.controller.AbstractController;
import ma.sir.easystock.zynerator.dto.AuditEntityDto;
import ma.sir.easystock.zynerator.util.PaginatedList;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.sir.easystock.zynerator.process.Result;

import org.springframework.web.multipart.MultipartFile;
import ma.sir.easystock.zynerator.dto.FileTempDto;

@Api("Manages vente services")
@RestController
@RequestMapping("/api/admin/vente/")
public class VenteRestAdmin  extends AbstractController<Vente, VenteDto, VenteHistory, VenteCriteria, VenteHistoryCriteria, VenteAdminService, VenteConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all ventes")
    @GetMapping("")
    public ResponseEntity<List<VenteDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all ventes")
    @GetMapping("optimized")
    public ResponseEntity<List<VenteDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a vente by id")
    @GetMapping("id/{id}")
    public ResponseEntity<VenteDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  vente")
    @PostMapping("")
    public ResponseEntity<VenteDto> save(@RequestBody VenteDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  vente")
    @PutMapping("")
    public ResponseEntity<VenteDto> update(@RequestBody VenteDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of vente")
    @PostMapping("multiple")
    public ResponseEntity<List<VenteDto>> delete(@RequestBody List<VenteDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified vente")
    @DeleteMapping("")
    public ResponseEntity<VenteDto> delete(@RequestBody VenteDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified vente")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple ventes by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("find by store id")
    @GetMapping("store/id/{id}")
    public List<Vente> findByStoreId(@PathVariable Long id){
        return service.findByStoreId(id);
    }
    @ApiOperation("delete by store id")
    @DeleteMapping("store/id/{id}")
    public int deleteByStoreId(@PathVariable Long id){
        return service.deleteByStoreId(id);
    }
    @ApiOperation("find by client id")
    @GetMapping("client/id/{id}")
    public List<Vente> findByClientId(@PathVariable Long id){
        return service.findByClientId(id);
    }
    @ApiOperation("delete by client id")
    @DeleteMapping("client/id/{id}")
    public int deleteByClientId(@PathVariable Long id){
        return service.deleteByClientId(id);
    }
    @ApiOperation("Finds a vente and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<VenteDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @ApiOperation("Finds ventes by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<VenteDto>> findByCriteria(@RequestBody VenteCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated ventes by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody VenteCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports ventes by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody VenteCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets vente data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody VenteCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets vente history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets vente paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody VenteHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports vente history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody VenteHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets vente history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody VenteHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public VenteRestAdmin (VenteAdminService service, VenteConverter converter) {
        super(service, converter);
    }


}