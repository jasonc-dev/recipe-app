package guru.springframework.recipeapp.services;

import guru.springframework.recipeapp.commands.UnitOfMeasureCommand;
import guru.springframework.recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.recipeapp.domain.UnitOfMeasure;
import guru.springframework.recipeapp.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand uomCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService uomService;
    @Mock UnitOfMeasureRepository uomRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        uomService = new UnitOfMeasureServiceImpl(uomRepository, uomCommand);
    }

    @Test
    public void listAllUoms() throws Exception {
        //given
        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        UnitOfMeasure uom1 = new UnitOfMeasure();
        uom1.setId(1L);
        unitOfMeasures.add(uom1);
        UnitOfMeasure uom2 = new UnitOfMeasure();
        uom2.setId(2L);
        unitOfMeasures.add(uom2);
        when(uomRepository.findAll()).thenReturn(unitOfMeasures);
        //when
        Set<UnitOfMeasureCommand> commands = uomService.listAllUoms();
        //then
        assertEquals(2, commands.size());
        verify(uomRepository, times(1)).findAll();
    }
}