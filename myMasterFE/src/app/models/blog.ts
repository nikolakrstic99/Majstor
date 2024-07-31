export class Blog {
  id: number = 0;
  image: string = '';
  heading: string = '';
  subHeading: string = '';
  blogDate: string = '';
  blogDetail: string = '';
  status: BlogStatus = BlogStatus.Draft;
}

export enum BlogStatus {
  Draft = 'draft',
  Published = 'published',
  Deleted = 'deleted'
}
