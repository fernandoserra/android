package com.program.codemobile.itunesapplication.persistence;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite_table")
public class FavoriteEntity {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "trackId")
    private String trackId;

    @ColumnInfo(name = "artworkUrl100")
    private String artworkUrl100;

    @ColumnInfo(name = "trackTimeMillis")
    private String trackTimeMillis;

    @ColumnInfo(name = "longDescription")
    private String longDescription;

    @ColumnInfo(name = "country")
    private String country;

    @ColumnInfo(name = "previewUrl")
    private String previewUrl;

    @ColumnInfo(name = "collectionHdPrice")
    private String collectionHdPrice;

    @ColumnInfo(name = "artistId")
    private String artistId;

    @ColumnInfo(name = "trackName")
    private String trackName;

    @ColumnInfo(name = "collectionName")
    private String collectionName;

    @ColumnInfo(name = "artistViewUrl")
    private String artistViewUrl;

    @ColumnInfo(name = "discNumber")
    private String discNumber;

    @ColumnInfo(name = "trackCount")
    private String trackCount;

    @ColumnInfo(name = "artworkUrl30")
    private String artworkUrl30;

    @ColumnInfo(name = "wrapperType")
    private String wrapperType;

    @ColumnInfo(name = "currency")
    private String currency;

    @ColumnInfo(name = "collectionId")
    private String collectionId;

    @ColumnInfo(name = "trackExplicitness")
    private String trackExplicitness;

    @ColumnInfo(name = "collectionViewUrl")
    private String collectionViewUrl;

    @ColumnInfo(name = "trackHdPrice")
    private String trackHdPrice;

    @ColumnInfo(name = "contentAdvisoryRating")
    private String contentAdvisoryRating;

    @ColumnInfo(name = "trackNumber")
    private String trackNumber;

    @ColumnInfo(name = "releaseDate")
    private String releaseDate;

    @ColumnInfo(name = "kind")
    private String kind;

    @ColumnInfo(name = "collectionPrice")
    private String collectionPrice;

    @ColumnInfo(name = "shortDescription")
    private String shortDescription;

    @ColumnInfo(name = "discCount")
    private String discCount;

    @ColumnInfo(name = "primaryGenreName")
    private String primaryGenreName;

    @ColumnInfo(name = "trackPrice")
    private String trackPrice;

    @ColumnInfo(name = "collectionExplicitness")
    private String collectionExplicitness;

    @ColumnInfo(name = "trackViewUrl")
    private String trackViewUrl;

    @ColumnInfo(name = "artworkUrl60")
    private String artworkUrl60;

    @ColumnInfo(name = "trackCensoredName")
    private String trackCensoredName;

    @ColumnInfo(name = "artistName")
    private String artistName;

    @ColumnInfo(name = "collectionCensoredName")
    private String collectionCensoredName;


    public FavoriteEntity(@NonNull String trackId, String artworkUrl100, String trackTimeMillis, String longDescription, String country, String previewUrl, String collectionHdPrice, String artistId, String trackName, String collectionName, String artistViewUrl, String discNumber, String trackCount, String artworkUrl30, String wrapperType, String currency, String collectionId, String trackExplicitness, String collectionViewUrl, String trackHdPrice, String contentAdvisoryRating, String trackNumber, String releaseDate, String kind, String collectionPrice, String shortDescription, String discCount, String primaryGenreName, String trackPrice, String collectionExplicitness, String trackViewUrl, String artworkUrl60, String trackCensoredName, String artistName, String collectionCensoredName) {
        this.trackId = trackId;
        this.artworkUrl100 = artworkUrl100;
        this.trackTimeMillis = trackTimeMillis;
        this.longDescription = longDescription;
        this.country = country;
        this.previewUrl = previewUrl;
        this.collectionHdPrice = collectionHdPrice;
        this.artistId = artistId;
        this.trackName = trackName;
        this.collectionName = collectionName;
        this.artistViewUrl = artistViewUrl;
        this.discNumber = discNumber;
        this.trackCount = trackCount;
        this.artworkUrl30 = artworkUrl30;
        this.wrapperType = wrapperType;
        this.currency = currency;
        this.collectionId = collectionId;
        this.trackExplicitness = trackExplicitness;
        this.collectionViewUrl = collectionViewUrl;
        this.trackHdPrice = trackHdPrice;
        this.contentAdvisoryRating = contentAdvisoryRating;
        this.trackNumber = trackNumber;
        this.releaseDate = releaseDate;
        this.kind = kind;
        this.collectionPrice = collectionPrice;
        this.shortDescription = shortDescription;
        this.discCount = discCount;
        this.primaryGenreName = primaryGenreName;
        this.trackPrice = trackPrice;
        this.collectionExplicitness = collectionExplicitness;
        this.trackViewUrl = trackViewUrl;
        this.artworkUrl60 = artworkUrl60;
        this.trackCensoredName = trackCensoredName;
        this.artistName = artistName;
        this.collectionCensoredName = collectionCensoredName;
    }



    @NonNull
    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(@NonNull String trackId) {
        this.trackId = trackId;
    }

    public String getArtworkUrl100() {
        return artworkUrl100;
    }

    public void setArtworkUrl100(String artworkUrl100) {
        this.artworkUrl100 = artworkUrl100;
    }

    public String getTrackTimeMillis() {
        return trackTimeMillis;
    }

    public void setTrackTimeMillis(String trackTimeMillis) {
        this.trackTimeMillis = trackTimeMillis;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public String getCollectionHdPrice() {
        return collectionHdPrice;
    }

    public void setCollectionHdPrice(String collectionHdPrice) {
        this.collectionHdPrice = collectionHdPrice;
    }

    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getArtistViewUrl() {
        return artistViewUrl;
    }

    public void setArtistViewUrl(String artistViewUrl) {
        this.artistViewUrl = artistViewUrl;
    }

    public String getDiscNumber() {
        return discNumber;
    }

    public void setDiscNumber(String discNumber) {
        this.discNumber = discNumber;
    }

    public String getTrackCount() {
        return trackCount;
    }

    public void setTrackCount(String trackCount) {
        this.trackCount = trackCount;
    }

    public String getArtworkUrl30() {
        return artworkUrl30;
    }

    public void setArtworkUrl30(String artworkUrl30) {
        this.artworkUrl30 = artworkUrl30;
    }

    public String getWrapperType() {
        return wrapperType;
    }

    public void setWrapperType(String wrapperType) {
        this.wrapperType = wrapperType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getTrackExplicitness() {
        return trackExplicitness;
    }

    public void setTrackExplicitness(String trackExplicitness) {
        this.trackExplicitness = trackExplicitness;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getTrackHdPrice() {
        return trackHdPrice;
    }

    public void setTrackHdPrice(String trackHdPrice) {
        this.trackHdPrice = trackHdPrice;
    }

    public String getContentAdvisoryRating() {
        return contentAdvisoryRating;
    }

    public void setContentAdvisoryRating(String contentAdvisoryRating) {
        this.contentAdvisoryRating = contentAdvisoryRating;
    }

    public String getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(String trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCollectionPrice() {
        return collectionPrice;
    }

    public void setCollectionPrice(String collectionPrice) {
        this.collectionPrice = collectionPrice;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDiscCount() {
        return discCount;
    }

    public void setDiscCount(String discCount) {
        this.discCount = discCount;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getCollectionExplicitness() {
        return collectionExplicitness;
    }

    public void setCollectionExplicitness(String collectionExplicitness) {
        this.collectionExplicitness = collectionExplicitness;
    }

    public String getTrackViewUrl() {
        return trackViewUrl;
    }

    public void setTrackViewUrl(String trackViewUrl) {
        this.trackViewUrl = trackViewUrl;
    }

    public String getArtworkUrl60() {
        return artworkUrl60;
    }

    public void setArtworkUrl60(String artworkUrl60) {
        this.artworkUrl60 = artworkUrl60;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }
}
