package isi.devops.gestion_etablissement.serviceImpl;

import isi.devops.gestion_etablissement.domaine.Classe;
import isi.devops.gestion_etablissement.repository.ClasseRepository;
import isi.devops.gestion_etablissement.service.ClasseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClasseServiceImplTest {

    @Mock
    private ClasseRepository classeRepository;

    @InjectMocks
    private ClasseServiceImpl classeService;

    private Classe classe;

    @BeforeEach
    void setUp() {
        classe = new Classe();
        classe.setId(1L);
        classe.setNom("Classe A");
    }

    @Test
    void testCreateClasse() {
        when(classeRepository.save(any(Classe.class))).thenReturn(classe);

        Classe result = classeService.createClasse(classe);

        assertNotNull(result);
        assertEquals("Classe A", result.getNom());
        verify(classeRepository, times(1)).save(any(Classe.class));
    }

    @Test
    void testGetClasseById_WhenExists() {
        when(classeRepository.findById(1L)).thenReturn(Optional.of(classe));

        Classe result = classeService.getClasseById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(classeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetClasseById_WhenNotExists() {
        when(classeRepository.findById(1L)).thenReturn(Optional.empty());

        Classe result = classeService.getClasseById(1L);

        assertNull(result);
        verify(classeRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAllClasses() {
        List<Classe> classes = Arrays.asList(classe, new Classe());
        when(classeRepository.findAll()).thenReturn(classes);

        List<Classe> result = classeService.getAllClasses();

        assertEquals(2, result.size());
        verify(classeRepository, times(1)).findAll();
    }

    @Test
    void testUpdateClasse_WhenExists() {
        when(classeRepository.existsById(1L)).thenReturn(true);
        when(classeRepository.save(any(Classe.class))).thenReturn(classe);

        Classe updatedClasse = new Classe();
        updatedClasse.setNom("Classe B");

        Classe result = classeService.updateClasse(1L, updatedClasse);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(classeRepository, times(1)).existsById(1L);
        verify(classeRepository, times(1)).save(updatedClasse);
    }

    @Test
    void testUpdateClasse_WhenNotExists() {
        when(classeRepository.existsById(1L)).thenReturn(false);

        Classe result = classeService.updateClasse(1L, new Classe());

        assertNull(result);
        verify(classeRepository, times(1)).existsById(1L);
        verify(classeRepository, never()).save(any(Classe.class));
    }

    @Test
    void testDeleteClasse() {
        doNothing().when(classeRepository).deleteById(1L);

        classeService.deleteClasse(1L);

        verify(classeRepository, times(1)).deleteById(1L);
    }
}
