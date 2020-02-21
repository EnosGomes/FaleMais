export abstract class BaseService {

  constructor(protected apiLocation: string) { }

  public getApiLocation(): string {
    return this.apiLocation;
  }

}
