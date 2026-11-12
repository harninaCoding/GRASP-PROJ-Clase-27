package services;

import java.util.Optional;

import modelo.Entity.NinoEso;

public interface CampamentoService {

    Optional<NinoEso> getNinoEsoById(int numeroNino);

	boolean create(NinoEso ninoEso);

	Optional<NinoEso> deleteNinoEsoById(int numeroNino);
}
