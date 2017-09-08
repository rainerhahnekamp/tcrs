
declare module 'endpoints' {

    interface ReservationAddRequest {
        startDatetime: Date;
        hours: number;
        courtId: string;
        clubUrl: string;
    }

    interface ClubsListResponse {
        url: string;
        name: string;
    }

    interface ReservationAddResponse {
        clubId: number;
        courtId: string;
        hours: number;
        startDatetime: Date;
        url: string;
    }

    interface ReservationResponse {
        id: string;
        startDatetime: Date;
        hours: number;
    }

}
