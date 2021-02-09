package it.unicam.ids.doit.service.impl;

import it.unicam.ids.doit.dao.TeamRepository;
import it.unicam.ids.doit.entity.Team;
import it.unicam.ids.doit.service.ProgettistaService;
import it.unicam.ids.doit.service.ProgettoService;
import it.unicam.ids.doit.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private ProgettoService progettoService;

    @Autowired
    private ProgettistaService progettistaService;

    /**
     * Costruttore del team
     * @param idProgetto progetto al quale appartiene il team
     * @return istanza del nuovo team
     */
    @Override
    public Team createTeam(Long idProgetto){
        Team team = new Team(idProgetto);
        //TODO e l id del proponente progetto? anche lui deve appartenere a questo progetto
        teamRepository.save(team);
        return team;
    }

    /**
     * Cancellazione del team, metodo che verrà richiamato in caso il proponente progetto rimuoverà il progetto
     * @param idTeam team che deve essere rimosso
     */
    @Override
    public void deleteTeam(Long idTeam){
        Team team = getTeam(idTeam);
        progettoService.removeTeam(team.getProgettoID());
        if(!team.getProgettistiTeam().isEmpty()) team.getProgettistiTeam().
                forEach(p -> progettistaService.removeTeam(p,idTeam));
        teamRepository.delete(team);
    }

    /**
     * Metodo per ottenere un singolo team
     * @param id del team da ricercare
     * @return team
     */
    @Override
    public Team getTeam(Long id){
        return teamRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    /**
     * Metodo per otternere una lista contente tutti i team
     * @return Lista di tutti i team
     */
    @Override
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    /**
     * Rimozione di un progettista da un team
     * @param idTeam team sul quela viene rimosso un progettista
     * @param idProgettista progettista da rimuovere dal team
     */
    @Override
    public void removeProgettista(Long idTeam, Long idProgettista){
        Team team = getTeam(idTeam);
        team.getProgettistiTeam().remove(idProgettista);
        //progettistiTeam.remove(p);
        teamRepository.save(team);
    }

    /**
     * Aggiunta progettista al team
     * @param idTeam team al quale viene aggiunto un progettista
     * @param idProgettista progettista da aggiungere al team
     */
    @Override
    public void addProgettista(Long idTeam, Long idProgettista){
        Team team = getTeam(idTeam);
        if(team.getProgettistiTeam().contains(idProgettista)){
            team.getProgettistiTeam().add(idProgettista);
            teamRepository.save(team);
        }
        //progettistiTeam.add(p);
    }

}
