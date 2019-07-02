package com.grosalex.giphy;

import com.google.gson.Gson;
import com.grosalex.giphy.contract.RandomGifContract;
import com.grosalex.giphy.model.Gif;
import com.grosalex.giphy.presenter.RandomGifPresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class RandomGifPresenterTest {

    private RandomGifPresenter randomGifPresenter;

    @Mock
    private RandomGifContract.View view;

    @Mock
    private RandomGifContract.Provider provider;

    @Captor
    private ArgumentCaptor<RandomGifContract.Provider.OnGifFetched> captor;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

        randomGifPresenter = new RandomGifPresenter(view, provider);
    }

    @Test
    public void loadRandomGif() {

        randomGifPresenter.getRandomGif();
        verify(provider).getRandomGif(captor.capture());
        captor.getValue().onSuccess(gif);
        verify(view).bind(gif);
    }



    private static final Gif gif = (new Gson()).fromJson("{\n" +
            "       \"type\": \"gif\",\n" +
            "       \"id\": \"9JtCgz1dhe89VpZdIO\",\n" +
            "       \"slug\": \"chef-9JtCgz1dhe89VpZdIO\",\n" +
            "       \"url\": \"https://giphy.com/gifs/chef-9JtCgz1dhe89VpZdIO\",\n" +
            "       \"bitly_gif_url\": \"https://gph.is/2Eix9Uy\",\n" +
            "       \"bitly_url\": \"https://gph.is/2Eix9Uy\",\n" +
            "       \"embed_url\": \"https://giphy.com/embed/9JtCgz1dhe89VpZdIO\",\n" +
            "       \"username\": \"\",\n" +
            "       \"source\": \"https://www.reddit.com/r/whitepeoplegifs/comments/7x0lry/dont_worry_im_a_professional_chef/\",\n" +
            "       \"content_url\": \"\",\n" +
            "       \"source_tld\": \"www.reddit.com\",\n" +
            "       \"source_post_url\": \"https://www.reddit.com/r/whitepeoplegifs/comments/7x0lry/dont_worry_im_a_professional_chef/\",\n" +
            "       \"is_sticker\": 0,\n" +
            "       \"import_datetime\": \"2018-02-12 13:11:20\",\n" +
            "       \"trending_datetime\": \"0000-00-00 00:00:00\",\n" +
            "       \"images\":\n" +
            "       {\n" +
            "           \"fixed_height_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200_s.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200_s.gif\",\n" +
            "               \"width\": \"113\",\n" +
            "               \"height\": \"200\",\n" +
            "               \"size\": \"7014\"\n" +
            "           },\n" +
            "           \"original_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy_s.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy_s.gif\",\n" +
            "               \"width\": \"362\",\n" +
            "               \"height\": \"640\",\n" +
            "               \"size\": \"67514\"\n" +
            "           },\n" +
            "           \"fixed_width\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200w.gif\",\n" +
            "               \"width\": \"200\",\n" +
            "               \"height\": \"354\",\n" +
            "               \"size\": \"21873845\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200w.mp4\",\n" +
            "               \"mp4_size\": \"5935373\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200w.webp\",\n" +
            "               \"webp_size\": \"20976690\"\n" +
            "           },\n" +
            "           \"fixed_height_small_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100_s.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100_s.gif\",\n" +
            "               \"width\": \"57\",\n" +
            "               \"height\": \"100\",\n" +
            "               \"size\": \"2336\"\n" +
            "           },\n" +
            "           \"fixed_height_downsampled\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200_d.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200_d.gif\",\n" +
            "               \"width\": \"113\",\n" +
            "               \"height\": \"200\",\n" +
            "               \"size\": \"44772\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200_d.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200_d.webp\",\n" +
            "               \"webp_size\": \"41304\"\n" +
            "           },\n" +
            "           \"preview\":\n" +
            "           {\n" +
            "               \"width\": \"100\",\n" +
            "               \"height\": \"178\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-preview.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-preview.mp4\",\n" +
            "               \"mp4_size\": \"29286\"\n" +
            "           },\n" +
            "           \"fixed_height_small\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100.gif\",\n" +
            "               \"width\": \"57\",\n" +
            "               \"height\": \"100\",\n" +
            "               \"size\": \"2227694\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100.mp4\",\n" +
            "               \"mp4_size\": \"1400040\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100.webp\",\n" +
            "               \"webp_size\": \"2258984\"\n" +
            "           },\n" +
            "           \"downsized_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-downsized_s.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-downsized_s.gif\",\n" +
            "               \"width\": \"249\",\n" +
            "               \"height\": \"441\",\n" +
            "               \"size\": \"35438\"\n" +
            "           },\n" +
            "           \"downsized\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-downsized.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-downsized.gif\",\n" +
            "               \"width\": \"249\",\n" +
            "               \"height\": \"441\",\n" +
            "               \"size\": \"1995102\"\n" +
            "           },\n" +
            "           \"downsized_large\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-downsized-large.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-downsized-large.gif\",\n" +
            "               \"width\": \"362\",\n" +
            "               \"height\": \"640\",\n" +
            "               \"size\": \"6739697\"\n" +
            "           },\n" +
            "           \"fixed_width_small_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100w_s.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100w_s.gif\",\n" +
            "               \"width\": \"100\",\n" +
            "               \"height\": \"177\",\n" +
            "               \"size\": \"6126\"\n" +
            "           },\n" +
            "           \"preview_webp\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-preview.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-preview.webp\",\n" +
            "               \"width\": \"98\",\n" +
            "               \"height\": \"174\",\n" +
            "               \"size\": \"48270\"\n" +
            "           },\n" +
            "           \"fixed_width_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w_s.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200w_s.gif\",\n" +
            "               \"width\": \"200\",\n" +
            "               \"height\": \"354\",\n" +
            "               \"size\": \"19913\"\n" +
            "           },\n" +
            "           \"fixed_width_small\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100w.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100w.gif\",\n" +
            "               \"width\": \"100\",\n" +
            "               \"height\": \"177\",\n" +
            "               \"size\": \"6412468\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100w.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100w.mp4\",\n" +
            "               \"mp4_size\": \"25099\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100w.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=100w.webp\",\n" +
            "               \"webp_size\": \"6334220\"\n" +
            "           },\n" +
            "           \"downsized_small\":\n" +
            "           {\n" +
            "               \"width\": \"84\",\n" +
            "               \"height\": \"150\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-downsized-small.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-downsized-small.mp4\",\n" +
            "               \"mp4_size\": \"142261\"\n" +
            "           },\n" +
            "           \"fixed_width_downsampled\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w_d.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200w_d.gif\",\n" +
            "               \"width\": \"200\",\n" +
            "               \"height\": \"354\",\n" +
            "               \"size\": \"127674\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w_d.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200w_d.webp\",\n" +
            "               \"webp_size\": \"111330\"\n" +
            "           },\n" +
            "           \"downsized_medium\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-downsized-medium.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-downsized-medium.gif\",\n" +
            "               \"width\": \"289\",\n" +
            "               \"height\": \"512\",\n" +
            "               \"size\": \"4005286\"\n" +
            "           },\n" +
            "           \"original\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy.gif\",\n" +
            "               \"width\": \"362\",\n" +
            "               \"height\": \"640\",\n" +
            "               \"size\": \"78469441\",\n" +
            "               \"frames\": \"1356\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy.mp4\",\n" +
            "               \"mp4_size\": \"53141398\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy.webp\",\n" +
            "               \"webp_size\": \"68960340\",\n" +
            "               \"hash\": \"eadbe6a9ffceb4af3a5ff6bcc159e594\"\n" +
            "           },\n" +
            "           \"fixed_height\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200.gif\",\n" +
            "               \"width\": \"113\",\n" +
            "               \"height\": \"200\",\n" +
            "               \"size\": \"7642361\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200.mp4\",\n" +
            "               \"mp4_size\": \"2472412\",\n" +
            "               \"webp\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200.webp?cid=9d3190e55d1bbcec55756c4c412387f7&rid=200.webp\",\n" +
            "               \"webp_size\": \"7547480\"\n" +
            "           },\n" +
            "           \"looping\":\n" +
            "           {\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-loop.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-loop.mp4\",\n" +
            "               \"mp4_size\": \"3888154\"\n" +
            "           },\n" +
            "           \"original_mp4\":\n" +
            "           {\n" +
            "               \"width\": \"480\",\n" +
            "               \"height\": \"848\",\n" +
            "               \"mp4\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.mp4?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy.mp4\",\n" +
            "               \"mp4_size\": \"53141398\"\n" +
            "           },\n" +
            "           \"preview_gif\":\n" +
            "           {\n" +
            "               \"url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy-preview.gif?cid=9d3190e55d1bbcec55756c4c412387f7&rid=giphy-preview.gif\",\n" +
            "               \"width\": \"97\",\n" +
            "               \"height\": \"172\",\n" +
            "               \"size\": \"49857\"\n" +
            "           },\n" +
            "           \"480w_still\":\n" +
            "           {\n" +
            "               \"url\": \"https://media3.giphy.com/media/9JtCgz1dhe89VpZdIO/480w_s.jpg?cid=9d3190e55d1bbcec55756c4c412387f7&rid=480w_s.jpg\",\n" +
            "               \"width\": \"480\",\n" +
            "               \"height\": \"849\"\n" +
            "           }\n" +
            "       },\n" +
            "       \"title\": \"chef GIF\",\n" +
            "       \"image_original_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.gif\",\n" +
            "       \"image_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.gif\",\n" +
            "       \"image_mp4_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/giphy.mp4\",\n" +
            "       \"image_frames\": \"1356\",\n" +
            "       \"image_width\": \"362\",\n" +
            "       \"image_height\": \"640\",\n" +
            "       \"fixed_height_downsampled_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200_d.gif\",\n" +
            "       \"fixed_height_downsampled_width\": \"113\",\n" +
            "       \"fixed_height_downsampled_height\": \"200\",\n" +
            "       \"fixed_width_downsampled_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/200w_d.gif\",\n" +
            "       \"fixed_width_downsampled_width\": \"200\",\n" +
            "       \"fixed_width_downsampled_height\": \"354\",\n" +
            "       \"fixed_height_small_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100.gif\",\n" +
            "       \"fixed_height_small_still_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100_s.gif\",\n" +
            "       \"fixed_height_small_width\": \"57\",\n" +
            "       \"fixed_height_small_height\": \"100\",\n" +
            "       \"fixed_width_small_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100w.gif\",\n" +
            "       \"fixed_width_small_still_url\": \"https://media0.giphy.com/media/9JtCgz1dhe89VpZdIO/100w_s.gif\",\n" +
            "       \"fixed_width_small_width\": \"100\",\n" +
            "       \"fixed_width_small_height\": \"177\",\n" +
            "       \"caption\": \"\"\n" +
            "   }", Gif.class);

}
