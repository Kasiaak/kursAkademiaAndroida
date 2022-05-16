package com.kasiaak.kursakademiaandroida.mock

import com.kasiaak.kursakademiaandroida.core.api.model.*
import com.kasiaak.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import com.kasiaak.kursakademiaandroida.features.characters.data.local.model.CharacterLastKnownLocationCached
import com.kasiaak.kursakademiaandroida.features.characters.data.local.model.CharacterOriginCached
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.Character
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.CharacterLastKnownLocation
import com.kasiaak.kursakademiaandroida.features.characters.domain.model.CharacterOrigin
import com.kasiaak.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import com.kasiaak.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import com.kasiaak.kursakademiaandroida.features.episodes.domain.model.Episode
import com.kasiaak.kursakademiaandroida.features.locations.data.local.model.LocationCached
import com.kasiaak.kursakademiaandroida.features.locations.domain.model.Location
import org.jetbrains.annotations.TestOnly

@TestOnly
fun ResponseInfo.Companion.mock() = ResponseInfo(
    count = 10,
    pages = 3,
    next = "nest page url",
    prev = "previous page url"
)

@TestOnly
fun EpisodeRemote.Companion.mock() = EpisodeRemote(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url",
    created = "example data"
)

@TestOnly
fun EpisodeResponse.Companion.mock() = EpisodeResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        EpisodeRemote.mock(),
        EpisodeRemote.mock(),
        EpisodeRemote.mock()
    )
)

@TestOnly
fun EpisodeCached.Companion.mock() = EpisodeCached(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun LocationRemote.Companion.mock() = LocationRemote(
    id = 1,
    name = "location name",
    dimension = "dimension name",
    type = "type name",
    residents = emptyList(),
    url = "url name",
    created = "example data"
)

@TestOnly
fun LocationResponse.Companion.mock() = LocationResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        LocationRemote.mock(),
        LocationRemote.mock(),
        LocationRemote.mock()
    )
)

@TestOnly
fun LocationCached.Companion.mock() = LocationCached(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun CharacterRemote.Companion.mock() = CharacterRemote(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    characterOriginRemote = CharacterRemote.CharacterOriginRemote(
        name = "location name",
        url = "location url"
    ),
    characterLastKnownLocationRemote = CharacterRemote.CharacterLastKnownLocationRemote(
        name = "location name",
        url = "location url"
    ),
    url = "character url",
    created = "example data",
    image = "character image url",
    episode = emptyList()
)

@TestOnly
fun CharacterResponse.Companion.mock() = CharacterResponse(
    info = ResponseInfo.mock(),
    results = listOf(
        CharacterRemote.mock(),
        CharacterRemote.mock(),
        CharacterRemote.mock()
    )
)

@TestOnly
fun CharacterCached.Companion.mock() = CharacterCached(
    id = 1,
    name = "character name",
    status = "character status",
    type = "character type",
    species = "character species",
    gender = "character species",
    origin = CharacterOriginCached(
        characterOriginName = "character origin cached name",
        characterOriginUrl = "character origin cached url"
    ),
    lastKnownLocation = CharacterLastKnownLocationCached(
        characterLastKnownLocationName = "character last known location cached name",
        characterLastKnownLocationUrl = "character last known location url"
    ),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

@TestOnly
fun Episode.Companion.mock() = Episode(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)

@TestOnly
fun Character.Companion.mock() = Character(
    id = 1,
    name = "character name",
    status = "character status",
    species = "character species",
    type = "character type",
    gender = "character gender",
    origin = CharacterOrigin.Companion.mock(),
    lastKnownLocation = CharacterLastKnownLocation.Companion.mock(),
    image = "character image",
    episode = emptyList(),
    url = "character url"
)

@TestOnly
fun CharacterLastKnownLocation.Companion.mock() = CharacterLastKnownLocation(
    name = "character last known location name",
    url = "character last known location url"
)

@TestOnly
fun CharacterOrigin.Companion.mock() = CharacterOrigin(
    name = "character origin name",
    url = "character origin url"
)

@TestOnly
fun Location.Companion.mock() = Location(
    id = 1,
    name = "location name",
    type = "location type",
    dimension = "location dimension",
    residents = emptyList(),
    url = "location url"
)

@TestOnly
fun EpisodeDisplayable.Companion.mock() = EpisodeDisplayable(
    id = 1,
    name = "episode name",
    airDate = "episode air date",
    code = "episode code",
    characters = emptyList(),
    url = "episode url"
)
