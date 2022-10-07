package com.example.demo.api;

import com.example.demo.dao.DaoFactory;
import com.example.demo.dao.IslandDAO;
import com.example.demo.dao.entity.Country;
import com.example.demo.dao.memory.MemoryIslandDAO;
import com.example.demo.model.Island;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Path("/islands")
public class IslandResource {

    private IslandDAO islandDAO;

    public IslandResource() {
        this.islandDAO = DaoFactory.getIslandDAO();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Island> islandList = islandDAO.findAll();
        return Response.ok(islandList).build();
    }

    @GET
    @Path("/{islandId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getIslandById(@PathParam("islandId") long idParam) {
        Optional<Island> optionalIsland = islandDAO.findById(idParam);

        if (optionalIsland.isPresent()) {
            return Response.ok(optionalIsland.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Island dto, @Context UriInfo uriInfo) {
        Island createdIsland = new Island(dto.getId(), dto.getName(), dto.getPictureUrl(), dto.getSurface(),
                dto.getInhabitants(), dto.getLatitude(), dto.getLongitude(), dto.getCountry());

        islandDAO.create(createdIsland);

        URI location = uriInfo
                .getRequestUriBuilder()
                .path(String.valueOf(createdIsland.getId()))
                .build();

        return Response.created(location).entity(createdIsland).build();
    }


    @PUT
    @Path("/{islandId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("islandId") long idParam, Island islandDto) {
        Optional<Island> optionalIsland = islandDAO.findById(idParam);
        if (optionalIsland.isPresent()) {
            new MemoryIslandDAO().edit(new Island(idParam, islandDto.getName(), islandDto.getPictureUrl(), 0, 0, 0, 0, new Country()));
            return getAll();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{islandId}")
    public Response delete(@PathParam("islandId") long idParam) {
        new MemoryIslandDAO().delete(idParam);
        return Response.noContent().build();
    }


}
