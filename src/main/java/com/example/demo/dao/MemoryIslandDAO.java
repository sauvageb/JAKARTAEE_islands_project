package com.example.demo.dao;

import com.example.demo.model.Island;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryIslandDAO implements IslandDAO {

    private static List<Island> islands = new ArrayList<Island>() {{
        Island moorea = new Island(
                1,
                "Moorea",
                "http://t1.gstatic.com/licensed-image?q=tbn:ANd9GcRZTnI79YTjGb4Co5qBZdh46_wmOtsXDL2RkMyDAUCJKXYC-huw7qKeT61F-fL7our1",
                134,
                16192,
                -17.533306,
                -149.8386601,
                "Polynésie française"
        );
        add(moorea);

        Island island2 = new Island(
                2,
                "Vieques",
                "https://www.bouger-voyager.com/wp-content/uploads/2016/01/baie-de-mosquito-640x380.jpg",
                135,
                9350,
                18.1262854,
                -65.4400985,
                "Porto Rico");
        add(island2);

        Island crete = new Island(3, "Crète", "https://www.poupadou.com/blog/wp-content/uploads/2018/10/Mpalos-plage-en-Cr%C3%A8te-scaled.jpg", 8450, 621340, 35.3084952, 24.4633423, "Grèce");
        add(crete);

        Island maui = new Island(
                4,
                "Maui",
                "http://t3.gstatic.com/licensed-image?q=tbn:ANd9GcQgrTB4xeUd96JEHVy1YWqEQo72SnRpfp06-3JaiJWvFMciOMvvrP28diG5-Ce2PQT6",
                1902,
                144444,
                20.8029568,
                -156.3106833,
                "USA");
        add(maui);

        Island tsushima = new Island(
                5L,
                "tsushima",
                "https://media.gettyimages.com/photos/aso-bay-tsushima-nagasaki-japan-picture-id109591602?s=2048x2048",
                696.26,
                39716,
                34.2053717,
                129.2946547,
                "japon"
        );
        add(tsushima);

        Island barbade = new Island(
                6L,
                "Barbade",
                "https://www.ou-et-quand.net/partir/images/illustration/barbade_408.jpg",
                430,
                294560,
                13.1500331,
                -59.5250305,
                "Barbade"
        );
        add(barbade);

        Island ileDeFrance = new Island(
                7L,
                "Ile de France",
                "https://www.usinenouvelle.com/mediatheque/0/7/5/000353570_896x598_c.jpg",
                12012,
                12210000,
                48.8499198,
                2.6370411,
                "France"
        );
        add(ileDeFrance);


        Island molokai = new Island(
                8L,
                "Molokai",
                "https://about.hawaiilife.com/wp-content/uploads/2018/03/62c8b451fed2d74668d6aba8eb3f579c5d5cb1bc51e09770c5a65b7681a9d32c.jpg",
                673,
                7404,
                21.1344895,
                -157.0071539,
                "Etats-Unis"
        );
        add(molokai);

        Island island9 = new Island(9L,
                "Sardaigne",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Cala_Goloritze_o.jpg/1280px-Cala_Goloritze_o.jpg",
                24090,
                1654796,
                40.121310,
                9.010441, "Italie");
        add(island9);


        Island island10 = new Island(10,
                "île de Baffin",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Baffin_Island_Northeast_Coast_1997-08-07.jpg/1280px-Baffin_Island_Northeast_Coast_1997-08-07.jpg",
                507451,
                11000,
                65.86558450066828,
                -71.1130507111078,
                "Canada");
        add(island10);

        Island palawan = new Island(
                11,
                "Palawan",
                "https://www.costacroisieres.fr/content/dam/costa/costa-magazine/articles-magazine/islands/most-beautiful-islands/10-palawan.jpg.image.1296.974.high.jpg",
                12189,
                430000,
                9.6481,
                118.732,
                "Philippines");
        add(palawan);

        Island island12 = new Island(
                12L,
                "Okinawa",
                "https://s3-ap-northeast-1.amazonaws.com/psh-ex-ftnikkei-3937bb4/images/6/8/2/0/40180286-3-eng-GB/Cropped-165138442620220501TKY%20Okinawa%20naminoue_shrine_23_lbvhey.jpg",
                1207,
                1230000,
                26.5707754,
                128.0255901,
                "Préfecture d'Okinawa, Japon"
        );
        add(island12);

        Island brehat = new Island(
                13L,
                "Bréhat",
                "https://www.bretagne.com/sites/default/files/post/Guide_pratique_ile_br%C3%A9hat_photo_Dominique_Douard.jpg",
                3,
                378,
                48.8461,
                -2.999,
                "France");
        add(brehat);

        Island gotland = new Island(14L,
                "Gotland",
                "https://www.worldatlas.com/r/w1200-q80/upload/68/f7/02/shutterstock-1468615610.jpg",
                3183.7,
                58595,
                57.30,
                18.30,
                "Sweden");
        add(gotland);

        Island djerba = new Island(
                16L,
                "Djerba",
                "https://nova-ott-images-tn.ssl.cdn.cra.cz/rx1920/a1929463-5b14-4066-876a-101360daec11",
                514,
                163726,
                33.48,
                10.51,
                "Tunisie"
        );
        add(djerba);

        Island malaMala = new Island(
                15L,
                "Mala Mala",
                "https://media.cntraveler.com/photos/59d4ea0c46f62157c95ac441/1:1/w_3386,h_3386,c_limit/21_Fiji_GettyImages-150956356.jpg",
                18274,
                926276,
                -17.713371,
                178.065033,
                "Fiji"
        );
        add(malaMala);
    }};

    @Override
    public List<Island> findAll() {
        return islands;
    }

    @Override
    public boolean create(Island island) {
        island.setId(islands.size() + 1L);
        return islands.add(island);
    }


    @Override
    public Optional<Island> findById(long idParam) {
        return islands
                .stream()
                .filter(i -> i.getId() == idParam)
                .findFirst();
    }

    @Override
    public boolean delete(long id) {
        if (findById(id).isPresent()) {
            islands = islands
                    .stream()
                    .filter(island -> island.getId() != id)
                    .collect(Collectors.toList());
            return true;
        }
        return false;
    }

    @Override
    public boolean edit(Island islandToEdit) {
        Optional<Island> islandOpt = findById(islandToEdit.getId());
        if (islandOpt.isPresent()) {

            Island island = islandOpt.get();
            island.setName(islandToEdit.getName());
            island.setPictureUrl(islandToEdit.getPictureUrl());

            return true;
        }
        return false;
    }
}
