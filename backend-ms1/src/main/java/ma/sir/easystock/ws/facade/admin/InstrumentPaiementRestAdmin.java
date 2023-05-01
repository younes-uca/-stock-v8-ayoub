package  ma.sir.easystock.ws.facade.admin;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ma.sir.easystock.bean.core.InstrumentPaiement;
import ma.sir.easystock.bean.history.InstrumentPaiementHistory;
import ma.sir.easystock.dao.criteria.core.InstrumentPaiementCriteria;
import ma.sir.easystock.dao.criteria.history.InstrumentPaiementHistoryCriteria;
import ma.sir.easystock.service.facade.admin.InstrumentPaiementAdminService;
import ma.sir.easystock.ws.converter.InstrumentPaiementConverter;
import ma.sir.easystock.ws.dto.InstrumentPaiementDto;
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

@Api("Manages instrumentPaiement services")
@RestController
@RequestMapping("/api/admin/instrumentPaiement/")
public class InstrumentPaiementRestAdmin  extends AbstractController<InstrumentPaiement, InstrumentPaiementDto, InstrumentPaiementHistory, InstrumentPaiementCriteria, InstrumentPaiementHistoryCriteria, InstrumentPaiementAdminService, InstrumentPaiementConverter> {



    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }

    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @ApiOperation("Finds a list of all instrumentPaiements")
    @GetMapping("")
    public ResponseEntity<List<InstrumentPaiementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @ApiOperation("Finds an optimized list of all instrumentPaiements")
    @GetMapping("optimized")
    public ResponseEntity<List<InstrumentPaiementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @ApiOperation("Finds a instrumentPaiement by id")
    @GetMapping("id/{id}")
    public ResponseEntity<InstrumentPaiementDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @ApiOperation("Saves the specified  instrumentPaiement")
    @PostMapping("")
    public ResponseEntity<InstrumentPaiementDto> save(@RequestBody InstrumentPaiementDto dto) throws Exception {
        return super.save(dto);
    }

    @ApiOperation("Updates the specified  instrumentPaiement")
    @PutMapping("")
    public ResponseEntity<InstrumentPaiementDto> update(@RequestBody InstrumentPaiementDto dto) throws Exception {
        return super.update(dto);
    }

    @ApiOperation("Delete list of instrumentPaiement")
    @PostMapping("multiple")
    public ResponseEntity<List<InstrumentPaiementDto>> delete(@RequestBody List<InstrumentPaiementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @ApiOperation("Delete the specified instrumentPaiement")
    @DeleteMapping("")
    public ResponseEntity<InstrumentPaiementDto> delete(@RequestBody InstrumentPaiementDto dto) throws Exception {
            return super.delete(dto);
    }

    @ApiOperation("Delete the specified instrumentPaiement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @ApiOperation("Delete multiple instrumentPaiements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @ApiOperation("Finds instrumentPaiements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<InstrumentPaiementDto>> findByCriteria(@RequestBody InstrumentPaiementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @ApiOperation("Finds paginated instrumentPaiements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody InstrumentPaiementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports instrumentPaiements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody InstrumentPaiementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @ApiOperation("Gets instrumentPaiement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody InstrumentPaiementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }

    @ApiOperation("Gets instrumentPaiement history by id")
    @GetMapping("history/id/{id}")
    public ResponseEntity<AuditEntityDto> findHistoryById(@PathVariable("id") Long id) throws Exception {
        return super.findHistoryById(id);
    }

    @ApiOperation("Gets instrumentPaiement paginated history by criteria")
    @PostMapping("history-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findHistoryPaginatedByCriteria(@RequestBody InstrumentPaiementHistoryCriteria criteria) throws Exception {
        return super.findHistoryPaginatedByCriteria(criteria);
    }

    @ApiOperation("Exports instrumentPaiement history by criteria")
    @PostMapping("export-history")
    public ResponseEntity<InputStreamResource> exportHistory(@RequestBody InstrumentPaiementHistoryCriteria criteria) throws Exception {
        return super.exportHistory(criteria);
    }

    @ApiOperation("Gets instrumentPaiement history data size by criteria")
    @PostMapping("history-data-size")
    public ResponseEntity<Integer> getHistoryDataSize(@RequestBody InstrumentPaiementHistoryCriteria criteria) throws Exception {
        return super.getHistoryDataSize(criteria);
    }
    public InstrumentPaiementRestAdmin (InstrumentPaiementAdminService service, InstrumentPaiementConverter converter) {
        super(service, converter);
    }


}